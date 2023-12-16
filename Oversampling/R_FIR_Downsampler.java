/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_FIR_Downsampler implements R_IDownsampler
{
    public R_FIR_Downsampler( R_IFIR_Coeffs coeffs )
    {
        // at least two and then in powers of two
        m_coeffs        = coeffs.getCoeffs();
        m_osFactor      = coeffs.getOSFactor();
        m_filterOrder   = m_coeffs.length;
        m_buffer        = new R_FIR_Buffer( m_filterOrder );
    }

    public double process( double[] values )
    {
        double output = 0;
        //////// DOWNSAMPLING
        m_buffer.addValue( values[0] );
        /* convalute with FIR coefficients */
        for( int j = 0; j < m_filterOrder; ++j )
        {
            output += m_buffer.getValue( j ) * m_coeffs[j];
        }

        /*
         * we only need to compute the output value for the first input value
         * as all other "ownsampled values will be discarded anyways.
         * but we still need to fill the buffer.
         */
        for( int i = 1; i < m_osFactor; ++i )
        {
            m_buffer.addValue( values[i] );
        }
        //////// DOWNSAMPLING

        return output;
    }

    public double process( R_IValueGenerator valueGen )
    {
        double output = 0;
        //////// DOWNSAMPLING
        m_buffer.addValue( valueGen.getValue() );
        /* convalute with FIR coefficients */
        for( int j = 0; j < m_filterOrder; ++j )
        {
            output += m_buffer.getValue( j ) * m_coeffs[j];
        }

        /*
         * we only need to compute the output value for the first input value
         * as all other "ownsampled values will be discarded anyways.
         * but we still need to fill the buffer.
         */
        for( int i = 1; i < m_osFactor; ++i )
        {
            m_buffer.addValue( valueGen.getValue() );
        }
        //////// DOWNSAMPLING

        return output;
    }

    private final double[]              m_coeffs;
    private R_FIR_Buffer                m_buffer;
    private final int                   m_osFactor;
    private final int                   m_filterOrder;
}
