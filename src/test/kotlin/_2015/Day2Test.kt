package _2015

import _2015.Day2.Companion.parse
import _2015.Day2.Companion.part1
import _2015.Day2.Companion.part2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun `tests for part1`(){
        var box = parse("2x3x4")
        assertEquals(58, part1(box))

        box = parse("1x1x10")
        assertEquals(43, part1(box))
    }

    @Test
    fun `tests for part2`(){
        var box = parse("2x3x4")
        assertEquals(34, part2(box))

        box = parse("1x1x10")
        assertEquals(14, part2(box))
    }
}