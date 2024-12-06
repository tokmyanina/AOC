package common

class Point2D(val row: Int, val col: Int) {

    fun north() = Point2D(row , col - 1)

    fun south() = Point2D(row , col + 1)

    fun west() = Point2D(row -1 ,col)

    fun east() = Point2D(row + 1, col)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point2D

        if (row != other.row) return false
        if (col != other.col) return false

        return true
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + col
        return result
    }
}