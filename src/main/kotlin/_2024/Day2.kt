package _2024

import _2024.Day2.Companion.part1
import common.getParsedCountOfResults
import kotlin.math.abs

class Day2 {
    companion object {
        fun String.part1(): Boolean {
            val data = this.split(" ").map { Integer.valueOf(it) }
            return checkList(data)
        }

        private fun checkList(data: List<Int>): Boolean {
            val first = data[1] - data[0]

            for (i in 1 until data.size) {
                val cur = data[i] - data[i - 1]
                if (abs(cur) > 3) return false
                if (abs(cur) < 1) return false
                if (first * cur < 0) return false
            }

            return true
        }

        fun String.part2(): Boolean{
            val data = this.split(" ").map { Integer.valueOf(it) }

            if (checkList(data)) return true

            for (i in data.indices) {
                val temp = data.subList(0, i).plus(data.subList(i + 1, data.size))
                if (checkList(temp)) return true
            }

            return false
        }

        fun result1(fileName: String) {
            getParsedCountOfResults(fileName, {s: String -> s}, {s: String -> s.part1()})
        }

        fun result2(fileName: String) {
            getParsedCountOfResults(fileName, {s: String -> s}, {s: String -> s.part2()})
        }
    }
}