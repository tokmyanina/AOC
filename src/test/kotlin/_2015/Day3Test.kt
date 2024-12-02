package _2015

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Test{
    @Test
    fun `tests for part1`() {
        assertEquals(2, Day3.part1(">"))
        assertEquals(4, Day3.part1("^>v<"))
        assertEquals(2, Day3.part1("^v^v^v^v^v"))
    }

    @Test
    fun `tests for part2`() {
        assertEquals(3, Day3.part2("^v"))
        assertEquals(3, Day3.part2("^>v<"))
        assertEquals(11, Day3.part2("^v^v^v^v^v"))
    }
}