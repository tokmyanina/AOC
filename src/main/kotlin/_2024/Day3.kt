package _2024

import common.getParsedSumOfResults
import common.readStrings


class Day3 {
    companion object {
        fun part1(s: String): Int {
           return s
               .split("mul(")
               .drop(1)
               .sumOf { processString(it) }
        }

        fun part2(s: String): Int{
            val t = s.substring(0, s.indexOf("do"))
            return s
                .split("do")
                .filter {  it.startsWith("()") || it == t }
                .flatMap { it.split("mul(")}
                .sumOf { processString(it) }
        }

        private fun processString(s: String): Int {
            val k = s.indexOf(")")
            if (k == -1) return 0
            val cur = s.substring(0, k).split(",")
            if (cur.size != 2) return 0
            try {
                val first = Integer.valueOf(cur[0])
                val second = Integer.valueOf(cur[1])
                if ((first !in 1..999) or (second !in 1..999)) return 0
                return first * second
            } catch (e: NumberFormatException) {
                return 0
            }
        }

        fun result1(fileName: String) {
            getParsedSumOfResults(fileName, {s: String -> s}, { s -> part1(s) })
        }

        fun result2(fileName: String) {
            println(part2(readStrings(fileName).reduce{a, b -> "$a$b"}))
        }
    }
}