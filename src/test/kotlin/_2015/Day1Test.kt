package _2015

import _2015.Day1.Companion.part2
import _2015.Day1.Companion.part1
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1Test {

    @Test
    fun `tests for part1`() {
        assertEquals(0, part1("(())"))
        assertEquals(0, part1("()()"))
        assertEquals(3, part1("((("))
        assertEquals(3, part1("(()(()("))
        assertEquals(3, part1("))((((("))
        assertEquals(-1, part1("())"))
        assertEquals(-1, part1("))("))
        assertEquals(-3, part1(")))"))
        assertEquals(-3, part1(")())())"))
    }

    @Test
    fun `tests for part2`() {
        assertEquals(1, part2("))((((("))
        assertEquals(3, part2("())"))
    }
}