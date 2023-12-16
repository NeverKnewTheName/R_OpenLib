/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_FIR_Coeffs_Kaiser_20_24_100_1X implements R_IFIR_Coeffs
{
    public static R_IFIR_Coeffs createMe()
    {
        return new R_FIR_Coeffs_Kaiser_20_24_100_1X();
    }
    public final int getOSFactor()
    {
        return 1;
    }
    public final double[] getCoeffs()
    {
        return m_coeffs;
    }

    private static final double[] m_coeffs =
    {
        -1.975919490648540e-06,
        6.894707842369745e-06,
        -1.625344504191127e-05,
        3.087851676791524e-05,
        -5.013974488499205e-05,
        7.096660997843557e-05,
        -8.694203496052527e-05,
        8.775692407147161e-05,
        -5.934923437662896e-05,
        -1.496753730083545e-05,
        1.521756792943363e-04,
        -3.659869010050648e-04,
        6.622415067171919e-04,
        -1.033755764535989e-03,
        1.455374321200799e-03,
        -1.880199716782684e-03,
        2.238072147447736e-03,
        -2.437313515570182e-03,
        2.370504047670167e-03,
        -1.924629391860528e-03,
        9.953567607215660e-04,
        4.954605129588500e-04,
        -2.580593002522434e-03,
        5.228615285260084e-03,
        -8.327779526916388e-03,
        1.167482784038136e-02,
        -1.497048650359949e-02,
        1.782240256379925e-02,
        -1.975475934101694e-02,
        2.022159659417681e-02,
        -1.861752907225001e-02,
        1.427383250286344e-02,
        -6.416032608218447e-03,
        -5.970322020086501e-03,
        2.450614039424245e-02,
        -5.246896204196543e-02,
        9.841087661455614e-02,
        -1.942631721736440e-01,
        6.305371759660792e-01,
        6.305371759660792e-01,
        -1.942631721736441e-01,
        9.841087661455615e-02,
        -5.246896204196542e-02,
        2.450614039424245e-02,
        -5.970322020086502e-03,
        -6.416032608218447e-03,
        1.427383250286344e-02,
        -1.861752907225001e-02,
        2.022159659417681e-02,
        -1.975475934101694e-02,
        1.782240256379925e-02,
        -1.497048650359949e-02,
        1.167482784038136e-02,
        -8.327779526916388e-03,
        5.228615285260084e-03,
        -2.580593002522433e-03,
        4.954605129588504e-04,
        9.953567607215662e-04,
        -1.924629391860528e-03,
        2.370504047670167e-03,
        -2.437313515570182e-03,
        2.238072147447736e-03,
        -1.880199716782683e-03,
        1.455374321200799e-03,
        -1.033755764535989e-03,
        6.622415067171917e-04,
        -3.659869010050648e-04,
        1.521756792943363e-04,
        -1.496753730083552e-05,
        -5.934923437662898e-05,
        8.775692407147151e-05,
        -8.694203496052523e-05,
        7.096660997843563e-05,
        -5.013974488499206e-05,
        3.087851676791524e-05,
        -1.625344504191127e-05,
        6.894707842369747e-06,
        -1.975919490648540e-06,
    };
}
