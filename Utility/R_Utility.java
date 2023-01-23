/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_utility;

/**
 * Useful utility functions to manipulate signals
 */
public class R_Utility
{
    /**
     * Clips the input value to the given threshold for positive and negative
     * values.
     *
     * @param value input value to clip
     * @param threshold value at which the input is cipped at for both positive
     * and negative range
     * @return value clipped to range +/- threshold
     */
    public static final double clipToThreshold( double value, double threshold )
    {
        return 0.5 * ( Math.abs( value + threshold ) - Math.abs( value - threshold ) );
    }

    /**
     * Clips the input value to the given threshold for positive and negative
     * values.
     *
     * @param value input value to clip
     * @param threshold value at which the input is cipped at for both positive
     * and negative range
     * @return value clipped to range +/- threshold
     */
    public static final int clipToThreshold( int value, int threshold )
    {
        return ( Math.abs( value + threshold ) - Math.abs( value - threshold ) ) >> 1;
    }

    /**
     * Clips the input value to the +/- 1.0 range.
     *
     * @param value input value to clip
     * @return value clipped to +/- 1.0
     */
    public static double clipOneToOne( double values )
    {
        return 0.5 * ( Math.abs( value + 1 ) - Math.abs( value - 1 ) );
    }

    /**
     * Clips the input value to the 0.0 to +1.0.
     *
     * @param value input value to clip
     * @return value clipped to the range 0.0 to +1.0.
     */
    public static final double clipZeroToOne( double value )
    {
        double absVal = value + Math.abs( value );
        return 0.25 * (
                Math.abs( absVal + 2.0 )
                - Math.abs( absVal - 2.0 )
               );
    }

    /**
     * Clips the input value to the range between min and max.
     *
     * @param value input value to restrict/clip
     * @param min lower threshold
     * @param max upper threshold
     * @return value clipped to the range min to max
     */
    public static final double restrictRange( double value, double min, double max )
    {
        return Math.min( max, Math.max( min, value ) );
    }

    /**
     * Clips the input value to the range between min and max.
     *
     * @param value input value to restrict/clip
     * @param min lower threshold
     * @param max upper threshold
     * @return value clipped to the range min to max
     */
    public static final int restrictRange( int value, int min, int max )
    {
        return Math.min( max, Math.max( min, value ) );
    }

    /**
     * Half rectify the input value by forcing negative values to 0.0.
     *
     * @param value input value to half rectify
     * @return half rectified value
     */
    public static final double halfRectify( double value )
    {
        return 0.5 * ( Math.abs( value ) + value );
    }

    /**
     * Half rectify the input value by forcing negative values to 0.0.
     *
     * @param value input value to half rectify
     * @return half rectified value
     */
    public static final int halfRectify( int value )
    {
        return ( Math.abs( value ) + value ) / 2;
    }

    /**
     * Wrap the input vlaue in the range 0.0 to +1.0.
     *
     * @param value input value to wrap
     * @return value wrapped in the range 0.0 to 1.0
     */
    public static final double wrapZeroToOne( double value )
    {
        value -= (int)value;
        value += R_Utility.halfRectify( -Math.signum( value ) );

        return value;
    }
}

