package _2015

import common.Point2D
import common.getResultByLine

class Day3 {
    companion object {
        fun part1(s: String): Int {
            val points = HashSet<Point2D>()

            var cur = Point2D(0, 0)
            points.add(cur)

            for (c in s) {
                val next = nextPoint(c, cur)

                points.add(next)

                cur = next
            }

            return points.size
        }

         fun part2(s: String): Int {
            val points = HashSet<Point2D>()

            var santa = Point2D(0, 0)
            var robot = Point2D(0, 0)

            points.add(santa)

            var index = 0

            while (index < s.length) {
                val nextSanta = nextPoint(s[index], santa)
                val nextRobot = nextPoint(s[index + 1], robot)

                points.add(nextSanta)
                points.add(nextRobot)

                santa = nextSanta
                robot = nextRobot

                index += 2
            }
            return points.size
        }

        fun result1(fileName: String) {
            getResultByLine(fileName) { s: String -> part1(s) }
        }

        fun result2(fileName: String) {
            getResultByLine(fileName) { s: String -> part2(s) }
        }

        private fun nextPoint(c: Char, cur: Point2D): Point2D {
            return when(c) {
                '^' -> cur.north()
                'v' -> cur.south()
                '>' -> cur.west()
                '<' -> cur.east()
                else -> cur
            }
        }
    }
}

