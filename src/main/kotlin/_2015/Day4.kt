package _2015

import common.getResultByLine
import common.md5
import common.md5HasLeadingZeroes

class Day4 {
    companion object {

        fun part1(s: String): Int {
            var md5 = md5(s)
            var number = 1
            while (!md5HasLeadingZeroes(md5, 5)) {
                number += 1
                md5 = md5("$s$number")
            }
            return number
        }

        fun part2(s: String): Int {
            var md5 = md5(s)
            var number = 1
            while (!md5HasLeadingZeroes(md5, 6)) {
                number += 1
                md5 = md5("$s$number")
            }
            return number
        }

        fun result1(fileName: String) {
            getResultByLine(fileName) { s: String -> part1(s) }
        }

        fun result2(fileName: String) {
            getResultByLine(fileName) { s: String -> part2(s) }
        }

        private fun String.hasFiveZeroes(): Boolean {
            return this.substring(0, 5) == "00000"
        }

        private fun String.hasSixZeroes(): Boolean {
            return this.substring(0, 6) == "000000"
        }
    }
}

