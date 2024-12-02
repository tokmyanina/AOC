package _2015

import common.md5
import common.md5AsString
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4KtTest{
    @Test
    fun `tests for hash function`() {
        assertTrue(md5AsString(md5("abcdef609043")).startsWith("000001dbbfa"))
        assertTrue(md5AsString(md5("pqrstuv1048970")).startsWith("000006136ef"))
    }

    @Test
    fun `tests for part1`() {
        println(md5AsString(md5("abcdef53245")))
        assertEquals(609043, Day4.part1("abcdef"))
        assertEquals(1048970, Day4.part1("pqrstuv"))
    }
}