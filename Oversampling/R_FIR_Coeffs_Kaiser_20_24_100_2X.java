/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_FIR_Coeffs_Kaiser_20_24_100_2X implements R_IFIR_Coeffs
{
    public static R_IFIR_Coeffs createMe()
    {
        return new R_FIR_Coeffs_Kaiser_20_24_100_2X();
    }
    public final int getOSFactor()
    {
        return 2;
    }
    public final double[] getCoeffs()
    {
        return m_coeffs;
    }

    private static final double[] m_coeffs =
    {
        -8.589946280220011e-07,
        1.675364549617027e-06,
        3.171902747446820e-06,
        -2.726246370130065e-06,
        -7.771894542268077e-06,
        2.486484391765998e-06,
        1.523324502728161e-05,
        9.637772940833730e-07,
        -2.546448227799785e-05,
        -1.022333567437559e-05,
        3.718684047931398e-05,
        2.824119282784332e-05,
        -4.742524178951239e-05,
        -5.767438088215689e-05,
        5.115644311223471e-05,
        9.993369501218362e-05,
        -4.128640431356247e-05,
        -1.539956324605961e-04,
        9.126456188752247e-06,
        2.151474021433160e-04,
        5.450413408303039e-05,
        -2.739161362602831e-04,
        -1.575067788033890e-04,
        3.154938138090985e-04,
        3.041447641285042e-04,
        -3.199859231959225e-04,
        -4.923269886504027e-04,
        2.637683066071967e-04,
        7.109149520160643e-04,
        -1.221246659495707e-04,
        -9.375579471015230e-04,
        -1.268399611999296e-04,
        1.137628801850973e-03,
        4.972403385542837e-04,
        -1.264816601787017e-03,
        -9.898825776392388e-04,
        1.263816982651751e-03,
        1.586867127214469e-03,
        -1.075343158134692e-03,
        -2.247185744440320e-03,
        6.433783653591878e-04,
        2.904231772094315e-03,
        7.576199622735557e-05,
        -3.466064769655573e-03,
        -1.103341648156455e-03,
        3.819044663561047e-03,
        2.428160716774378e-03,
        -3.835087330910271e-03,
        -3.997796194964713e-03,
        3.382327541614468e-03,
        5.712345900128148e-03,
        -2.338463000705617e-03,
        -7.421653878503013e-03,
        6.055667051694529e-04,
        8.926495995775708e-03,
        1.875228909590107e-03,
        -9.983417296137422e-03,
        -5.110983126136081e-03,
        1.031176741103849e-02,
        9.047926393037363e-03,
        -9.599764852233267e-03,
        -1.356769981243414e-02,
        7.503507157792385e-03,
        1.848989085707440e-02,
        -3.626881853670045e-03,
        -2.358122072122672e-02,
        -2.544425290224671e-03,
        2.857095321790209e-02,
        1.182519812517981e-02,
        -3.317130665394000e-02,
        -2.585509601310462e-02,
        3.710096730114762e-02,
        4.890733158457787e-02,
        -4.010932538861008e-02,
        -9.694115885538854e-02,
        4.199885674927012e-02,
        3.152027636950119e-01,
        4.573563853981739e-01,
        3.152027636950119e-01,
        4.199885674927012e-02,
        -9.694115885538855e-02,
        -4.010932538861009e-02,
        4.890733158457788e-02,
        3.710096730114762e-02,
        -2.585509601310462e-02,
        -3.317130665394000e-02,
        1.182519812517981e-02,
        2.857095321790209e-02,
        -2.544425290224671e-03,
        -2.358122072122672e-02,
        -3.626881853670045e-03,
        1.848989085707440e-02,
        7.503507157792386e-03,
        -1.356769981243414e-02,
        -9.599764852233263e-03,
        9.047926393037364e-03,
        1.031176741103849e-02,
        -5.110983126136081e-03,
        -9.983417296137422e-03,
        1.875228909590107e-03,
        8.926495995775706e-03,
        6.055667051694515e-04,
        -7.421653878503014e-03,
        -2.338463000705617e-03,
        5.712345900128149e-03,
        3.382327541614469e-03,
        -3.997796194964712e-03,
        -3.835087330910270e-03,
        2.428160716774374e-03,
        3.819044663561047e-03,
        -1.103341648156456e-03,
        -3.466064769655573e-03,
        7.576199622735649e-05,
        2.904231772094315e-03,
        6.433783653591879e-04,
        -2.247185744440319e-03,
        -1.075343158134692e-03,
        1.586867127214469e-03,
        1.263816982651751e-03,
        -9.898825776392390e-04,
        -1.264816601787017e-03,
        4.972403385542841e-04,
        1.137628801850973e-03,
        -1.268399611999296e-04,
        -9.375579471015232e-04,
        -1.221246659495711e-04,
        7.109149520160643e-04,
        2.637683066071967e-04,
        -4.923269886504027e-04,
        -3.199859231959224e-04,
        3.041447641285042e-04,
        3.154938138090983e-04,
        -1.575067788033890e-04,
        -2.739161362602830e-04,
        5.450413408303039e-05,
        2.151474021433160e-04,
        9.126456188752367e-06,
        -1.539956324605960e-04,
        -4.128640431356261e-05,
        9.993369501218364e-05,
        5.115644311223496e-05,
        -5.767438088215689e-05,
        -4.742524178951265e-05,
        2.824119282784330e-05,
        3.718684047931398e-05,
        -1.022333567437559e-05,
        -2.546448227799785e-05,
        9.637772940833764e-07,
        1.523324502728162e-05,
        2.486484391765997e-06,
        -7.771894542268077e-06,
        -2.726246370130062e-06,
        3.171902747446821e-06,
        1.675364549617027e-06,
        -8.589946280220011e-07,
    };
}