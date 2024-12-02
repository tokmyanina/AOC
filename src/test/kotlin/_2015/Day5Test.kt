package _2015

import _2015.Day5.Companion.part1
import _2015.Day5.Companion.part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun `tests for part1`() {
        assertTrue("ugknbfddgicrmopn".part1())
        assertTrue("aaa".part1())
        assertFalse("jchzalrnumimnmhp".part1())
        assertFalse("haegwjzuvuyypxyu".part1())
        assertFalse("dvszwmarrgswjxmb".part1())
    }

    @Test
    fun `tests for part2`() {
        assertTrue("qjhvhtzxzqqjkmpb".part2())
        assertTrue("xxyxx".part2())
        assertFalse("uurcxstgmygtbstg".part2())
        assertFalse("ieodomkazucvgmuy".part2())
    }
}