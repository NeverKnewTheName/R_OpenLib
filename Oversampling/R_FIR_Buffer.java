/*
 * Copyright 2023 Christian Neuberger/R_Ware
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.r_ware.r_openlib.r_oversampling;

public class R_FIR_Buffer
{
    public R_FIR_Buffer( int size )
    {
        int binaryExp = (int)Math.ceil( Math.log( size ) / Math.log( 2 ) );
        m_size      = 1 << binaryExp;
        m_sizeMask  = m_size - 1;
        m_buffer    = new double[m_size];
        m_cntr      = -1;
    }

    public void addValue( double value )
    {
        m_cntr = ( m_cntr + 1 ) & m_sizeMask;
        m_buffer[m_cntr] = value;
    }

    public double getValue( int index )
    {
        index = ( m_cntr - index ) & m_sizeMask;
        return m_buffer[index];
    }

    private double[]    m_buffer;
    private int         m_cntr;
    private final int   m_size;
    private final int   m_sizeMask;
}

