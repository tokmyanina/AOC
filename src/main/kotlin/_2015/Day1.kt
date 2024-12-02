package _2015

import common.getResultByLine

class Day1 {
    companion object {
        fun part1(s: String): Int {
            var result = 0

            for (c in s) {
                if (c == '(') {
                    result++
                } else {
                    result--
                }
            }

            return result
        }

        fun part2(s: String): Int {
            var position = 0
            var number = 0

            while (position >= 0) {
                if (s[number] == '(') {
                    position++
                } else {
                    position--
                }
                number++
            }

            return number
        }

        fun result1(fileName: String) {
            getResultByLine(fileName) { s: String -> part1(s) }
        }

        fun result2(fileName: String) {
            getResultByLine(fileName) { s: String -> part2(s) }
        }
    }
}