package _2024

import common.readDataAsTwoList
import kotlin.math.abs

class Day1 {
    companion object {
        private fun parse(s: String): List<Int> {
            return s.split("   ").map { Integer.valueOf(it) }
        }

        fun part1(data: Pair<List<Int>, List<Int>>): Int {
            val first = data.first.sorted()
            val second = data.second.sorted()
            return first.indices.sumOf { abs(second[it] - first[it]) }
        }

        fun part2(data: Pair<List<Int>, List<Int>>): Int {
            return data.first.sumOf { it * data.second.count { tmp -> tmp == it } }
        }

        fun result1(fileName: String) {
            val data = readDataAsTwoList(fileName) { s: String -> parse(s) }
            println(part1(data))
        }

        fun result2(fileName: String) {
            val data = readDataAsTwoList(fileName) { s: String -> parse(s) }
            println(part2(data))
        }
    }
}