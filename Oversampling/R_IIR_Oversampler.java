/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_IIR_Oversampler implements R_IOversampler
{
    public R_IIR_Oversampler( double baseSampleRate, int factor, double freq )
    {
        // at least two and then in powers of two
        m_osFactor      = Math.max( 2, factor & ~0x1 );
        m_sampleRate    = baseSampleRate * m_osFactor;
        m_upSampler     = new R_ResStackedBiquadLP( m_sampleRate, freq );
        m_downSampler   = new R_ResStackedBiquadLP( m_sampleRate, freq );
    }

    public double process( double value, R_IOversampledProcessor processor )
    {
        double[] os = new double[m_osFactor];
        os[0] = value; // first value is valid, others are zero-stuffed

        //////// OVERSAMPLING
        for( int i = 0; i < m_osFactor; ++i )
        {
            os[i] = m_upSampler.process( os[i] );
            os[i] = processor.process( m_osFactor * os[i] );
            os[i] = m_downSampler.process( os[i] );
        }
        //////// OVERSAMPLING

        return os[0];
    }

    private class R_ResStackedBiquadLP
    {
        public R_ResStackedBiquadLP( double sampleRate, double freq )
        {
            m_biquadCoeffs      = new double[7][7];
            calcBiquads( freq / sampleRate );
        }

        public double process( double value )
        {
            double result;

            result                  =
                value * m_biquadCoeffs[0][0] + m_biquadCoeffs[0][5];
            m_biquadCoeffs[0][5]    =
                value * m_biquadCoeffs[0][1] + m_biquadCoeffs[0][6]
                - m_biquadCoeffs[0][3] * result;
            m_biquadCoeffs[0][6]    =
                value * m_biquadCoeffs[0][2] - m_biquadCoeffs[0][4] * result;
            value = result;

            result                  =
                value * m_biquadCoeffs[1][0] + m_biquadCoeffs[1][5];
            m_biquadCoeffs[1][5]    =
                value * m_biquadCoeffs[1][1] + m_biquadCoeffs[1][6]
                - m_biquadCoeffs[1][3] * result;
            m_biquadCoeffs[1][6]    =
                value * m_biquadCoeffs[1][2] - m_biquadCoeffs[1][4] * result;
            value = result;

            result                  =
                value * m_biquadCoeffs[2][0] + m_biquadCoeffs[2][5];
            m_biquadCoeffs[2][5]    =
                value * m_biquadCoeffs[2][1] + m_biquadCoeffs[2][6]
                - m_biquadCoeffs[2][3] * result;
            m_biquadCoeffs[2][6]    =
                value * m_biquadCoeffs[2][2] - m_biquadCoeffs[2][4] * result;
            value = result;

            result                  =
                value * m_biquadCoeffs[3][0] + m_biquadCoeffs[3][5];
            m_biquadCoeffs[3][5]    =
                value * m_biquadCoeffs[3][1] + m_biquadCoeffs[3][6]
                - m_biquadCoeffs[3][3] * result;
            m_biquadCoeffs[3][6]    =
                value * m_biquadCoeffs[3][2] - m_biquadCoeffs[3][4] * result;

            result                  =
                value * m_biquadCoeffs[4][0] + m_biquadCoeffs[4][5];
            m_biquadCoeffs[4][5]    =
                value * m_biquadCoeffs[4][1] + m_biquadCoeffs[4][6]
                - m_biquadCoeffs[4][3] * result;
            m_biquadCoeffs[4][6]    =
                value * m_biquadCoeffs[4][2] - m_biquadCoeffs[4][4] * result;

            result                  =
                value * m_biquadCoeffs[5][0] + m_biquadCoeffs[5][5];
            m_biquadCoeffs[5][5]    =
                value * m_biquadCoeffs[5][1] + m_biquadCoeffs[5][6]
                - m_biquadCoeffs[5][3] * result;
            m_biquadCoeffs[5][6]    =
                value * m_biquadCoeffs[5][2] - m_biquadCoeffs[5][4] * result;

            result                  =
                value * m_biquadCoeffs[6][0] + m_biquadCoeffs[6][5];
            m_biquadCoeffs[6][5]    =
                value * m_biquadCoeffs[6][1] + m_biquadCoeffs[6][6]
                - m_biquadCoeffs[6][3] * result;
            m_biquadCoeffs[6][6]    =
                value * m_biquadCoeffs[6][2] - m_biquadCoeffs[6][4] * result;

            return result;
        }

        private void calcBiquads( double normalizedFreq )
        {
            double norm;
            double k = Math.tan( Math.PI * normalizedFreq );
            double kk = k * k;
            double resFact;

            /*
             * stack resonances to get a steeper rolloff with less filters
             */

            resFact = k / 0.50316379;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[0][0]    = kk * norm;
            m_biquadCoeffs[0][1]    = 2.0 * m_biquadCoeffs[0][0];
            m_biquadCoeffs[0][2]    = m_biquadCoeffs[0][0];
            m_biquadCoeffs[0][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[0][4]    = ( 1.0 - resFact + kk ) * norm;

            resFact = k / 0.52972649;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[1][0]    = kk * norm;
            m_biquadCoeffs[1][1]    = 2.0 * m_biquadCoeffs[1][0];
            m_biquadCoeffs[1][2]    = m_biquadCoeffs[1][0];
            m_biquadCoeffs[1][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[1][4]    = ( 1.0 - resFact + kk ) * norm;

            resFact = k / 0.59051105;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[2][0]    = kk * norm;
            m_biquadCoeffs[2][1]    = 2.0 * m_biquadCoeffs[2][0];
            m_biquadCoeffs[2][2]    = m_biquadCoeffs[2][0];
            m_biquadCoeffs[2][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[2][4]    = ( 1.0 - resFact + kk ) * norm;

            resFact = k / 0.70710678;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[3][0]    = kk * norm;
            m_biquadCoeffs[3][1]    = 2.0 * m_biquadCoeffs[3][0];
            m_biquadCoeffs[3][2]    = m_biquadCoeffs[3][0];
            m_biquadCoeffs[3][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[3][4]    = ( 1.0 - resFact + kk ) * norm;

            resFact = k / 0.93979296;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[4][0]    = kk * norm;
            m_biquadCoeffs[4][1]    = 2.0 * m_biquadCoeffs[4][0];
            m_biquadCoeffs[4][2]    = m_biquadCoeffs[4][0];
            m_biquadCoeffs[4][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[4][4]    = ( 1.0 - resFact + kk ) * norm;

            resFact = k / 1.5138713;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[5][0]    = kk * norm;
            m_biquadCoeffs[5][1]    = 2.0 * m_biquadCoeffs[5][0];
            m_biquadCoeffs[5][2]    = m_biquadCoeffs[5][0];
            m_biquadCoeffs[5][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[5][4]    = ( 1.0 - resFact + kk ) * norm;

            resFact = k / 4.4657021;
            norm    = 1.0 / ( 1.0 + resFact + kk );
            m_biquadCoeffs[6][0]    = kk * norm;
            m_biquadCoeffs[6][1]    = 2.0 * m_biquadCoeffs[6][0];
            m_biquadCoeffs[6][2]    = m_biquadCoeffs[6][0];
            m_biquadCoeffs[6][3]    = 2.0 * ( kk - 1.0 ) * norm;
            m_biquadCoeffs[6][4]    = ( 1.0 - resFact + kk ) * norm;
        }

        // stores freq, res, coefficients and past values
        private double[][]        m_biquadCoeffs;
    }

    private double                  m_sampleRate;
    private int                     m_osFactor;
    private R_ResStackedBiquadLP    m_upSampler;
    private R_ResStackedBiquadLP    m_downSampler;
}
