/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_FIR_Oversampler implements R_IOversampler
{
    public R_FIR_Oversampler( R_IFIR_Coeffs coeffs )
    {
        // at least two and then in powers of two
        m_coeffs        = coeffs.getCoeffs();
        m_osFactor      = coeffs.getOSFactor();
        m_filterOrder   = m_coeffs.length;
        m_bufferUp      = new R_FIR_Buffer( m_filterOrder );
        m_bufferDown    = new R_FIR_Buffer( m_filterOrder );
        int cacheSize   =
            (int)Math.ceil( m_filterOrder / m_osFactor ) + m_osFactor;
        m_valueCache    = new double[ cacheSize ];
    }

    public double process( double value, R_IOversampledProcessor processor )
    {
        double[] os = new double[m_osFactor];

        m_bufferUp.addValue( value );
        value = 0;
        /* pre-populate cachce to save on retrieval cost */
        for( int k = 0; k < m_valueCache.length; ++k )
        {
            m_valueCache[k] = m_bufferUp.getValue( k );
        }

        for( int i = 0; i < m_osFactor; ++i )
        {
            double output = 0;

            //// UPSAMPLE ////
            for( int j = i, k = 0; j < m_filterOrder; j+=m_osFactor, ++k )
            {
                output += m_valueCache[k] * m_coeffs[j];
            }
            os[i] = m_osFactor * output;
            //// \UPSAMPLE ////

            //// PROCESS ////
            os[i] = processor.process( os[i] );
            //// \PROCESS ////

            //// DOWNSAMPLE ////
            m_bufferDown.addValue( os[i] );
            if( i == 0 )
            {
                for( int j = 0; j < m_filterOrder; ++j )
                {
                    value += m_bufferDown.getValue( j ) * m_coeffs[j];
                }
            }
            //// \DOWNSAMPLE ////
        }

        return value;
    }

    private final double[]              m_coeffs;
    private double[]                    m_valueCache;
    private R_FIR_Buffer                m_bufferUp;
    private R_FIR_Buffer                m_bufferDown;
    private final int                   m_osFactor;
    private final int                   m_filterOrder;
}
