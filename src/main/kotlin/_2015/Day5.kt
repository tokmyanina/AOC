package _2015

import common.countOfVowels
import common.getParsedCountOfResults

class Day5 {
    companion object {
        fun String.part1(): Boolean {
            return this.hasThreeVowels() &&
                    this.hasTwiceLetters() &&
                    !this.hasConsequitiveChars()
        }

        fun String.part2(): Boolean{
            return this.hasRepeatablePair() && this.hasXYX()
        }

        fun result1(fileName: String) {
            getParsedCountOfResults(fileName, {s: String -> s}, {s: String -> s.part1()})
        }

        fun result2(fileName: String) {
            getParsedCountOfResults(fileName, {s: String -> s}, {s: String -> s.part2()})
        }

        private fun String.hasXYX(): Boolean {
            for (i in 2 until this.length) {
                if (this[i] == this[i - 2]) return true
            }
            return false
        }

        private fun String.hasRepeatablePair(): Boolean{
            for (i in 0 until this.length - 1) {
                val cur = this.substring(i, i + 2)
                if (this.indexOf(cur, i + 2) >= 0) {
                    return true
                }
            }
            return false
        }

        private fun String.hasThreeVowels(): Boolean {
            return this.countOfVowels() >= 3
        }

        private fun String.hasTwiceLetters(): Boolean {
            for (i in 1 until this.length) {
                if (this[i] == this[i - 1]) return true
            }
            return false
        }

        private fun String.hasConsequitiveChars(): Boolean {
            if (this.contains("ab")) return true
            if (this.contains("cd")) return true
            if (this.contains("pq")) return true
            if (this.contains("xy")) return true
            return false
        }
    }
}