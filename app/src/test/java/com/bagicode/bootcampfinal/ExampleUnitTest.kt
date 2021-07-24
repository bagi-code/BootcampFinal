package com.bagicode.bootcampfinal

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun tambahNilai() {
       var a = 10
       var b = 10
       var c = a+b
       System.out.println(c)
    }
}