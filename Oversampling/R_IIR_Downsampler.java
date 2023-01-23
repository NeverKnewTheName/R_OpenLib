/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_IIR_Downsampler implements R_IDownsampler
{
    public R_IIR_Downsampler( double baseSampleRate, int factor, double freq )
    {
        // at least two and then in powers of two
        m_osFactor      = Math.max( 2, factor & ~0x1 );
        m_sampleRate    = baseSampleRate * m_osFactor;
        m_downSampler   = new R_ResStackedResampleFilter( m_sampleRate, freq );
    }

    public double process( double[] values )
    {
        //////// DOWNSAMPLING
        values[0] = m_downSampler.process( values[0] );
        for( int i = 1; i < m_osFactor; ++i )
        {
            m_downSampler.process( values[i] );
        }
        //////// DOWNSAMPLING

        return values[0];
    }

    public double process( R_IValueGenerator valueGen )
    {
        double value;

        //////// DOWNSAMPLING
        value = m_downSampler.process( valueGen.getValue() );

        for( int i = 1; i < m_osFactor; ++i )
        {
            m_downSampler.process( valueGen.getValue() );
        }
        //////// DOWNSAMPLING

        return value;
    }

    private double                      m_sampleRate;
    private int                         m_osFactor;
    private R_ResStackedResampleFilter  m_downSampler;
}
