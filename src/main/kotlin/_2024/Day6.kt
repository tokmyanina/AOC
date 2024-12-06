package _2024

import common.*

class Day6 {
    companion object {
        fun part1(filename: String): Int {
            val data = readDataAs2DArray(filename, 1, 'Z')
            var cur = start(data)
            data[cur.point.row][cur.point.col] = getSymbol(cur.dir)
            var count = 1
            while (data[cur.point.row][cur.point.col] != 'Z') {
                cur = step(data, cur)
                if (cur.isNew) {
                    count += 1
                }
                if (data[cur.point.row][cur.point.col] != 'Z') {
                    data[cur.point.row][cur.point.col] = getSymbol(cur.dir)
                }
            }
            return count
        }

        fun part2(filename: String): Int{
            val data = readDataAs2DArray(filename, 1, 'Z')
            val cur = start(data)
            val row = cur.point.row
            val col = cur.point.col
            data[cur.point.row][cur.point.col] = getSymbol(cur.dir)
            var count = 0
            for (i in data.indices) {
                for (j in data[0].indices) {
                    clean(data, row, col)
                    if (data[i][j] == '.') {
                        data[i][j] = '#'
                        if (checkCycle(data, cur)) {
                            count += 1
                        }
                        data[i][j] = '.'
                    }
                }
            }
            return count
        }

        private fun clean(data: Point2DArray, row: Int, col: Int) {
            for (i in data.indices) {
                for (j in data[0].indices) {
                    if ("NSWO".contains(data[i][j])) {
                        data[i][j] = '.'
                    }
                }
            }
            data[row][col] = 'N'
        }

        private fun checkCycle(data: Point2DArray, start: Point): Boolean {
            var cur = start
            while (data[cur.point.row][cur.point.col] != 'Z') {
                cur = step(data, cur)
                if (data[cur.point.row][cur.point.col] != 'Z') {
                    val symbol = data[cur.point.row][cur.point.col]
                    if (symbol == getSymbol(cur.dir)) {
                        return true
                    }
                    data[cur.point.row][cur.point.col] = getSymbol(cur.dir)
                }
            }
            return false
        }

        private fun step(data: Point2DArray, start: Point): Point {
            var dir = start.dir
            val row = start.point.row
            val col = start.point.col

            var next = data[row + dir.dX][col + dir.dY]
            while (next == '#') {
                dir = right(dir)
                next = data[row + dir.dX][col + dir.dY]
            }
            val isNew = data[row + dir.dX][col + dir.dY] == '.'
            return Point(
                point = Point2D(row + dir.dX,col + dir.dY),
                dir = dir,
                isNew = isNew
            )
        }

        private fun start(data: Point2DArray): Point {
            for (i in data.indices) {
                for (j in data[0].indices) {
                    if (data[i][j] == '^') {
                        return Point(
                            point = Point2D(i, j),
                            dir = Direction.NORD
                        )
                    }
                }
            }
            return Point(
                point = Point2D(-1, -1),
                dir = Direction.NORD
            )
        }

        fun result1(fileName: String) {
            println(part1(fileName))
        }

        fun result2(fileName: String) {
            println(part2(fileName))
        }
    }
}

class Point(
    val point: Point2D,
    val dir: Direction,
    val isNew: Boolean = true,
)