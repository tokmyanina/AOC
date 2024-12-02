package _2015

import common.getParsedSumOfResults

class Box(val height: Int, val width: Int, val depth: Int)

class Day2 {
    companion object {

        fun parse(s: String): Box {
            val sides = s.split("x").map { Integer.valueOf(it) }
            return Box(sides[0], sides[1], sides[2])
        }

        fun part1(box: Box): Int {
            val faces = listOf(
                box.width * box.height,
                box.width * box.depth,
                box.height * box.depth
            )
            return (2 * faces.sum() + faces.min())
        }

        fun part2(box: Box): Int {
            val sides = listOf(box.width, box.height, box.depth)

            return (sides.sum() - sides.max()) * 2 + sides.fold(1) { acc, cur -> acc * cur }
        }

        fun result1(fileName: String) {
            getParsedSumOfResults(fileName, {s: String -> parse(s) }, {box: Box -> part1(box) })
        }

        fun result2(fileName: String) {
            getParsedSumOfResults(fileName, {s: String -> parse(s) }, {box: Box -> part2(box) })
        }
    }
}