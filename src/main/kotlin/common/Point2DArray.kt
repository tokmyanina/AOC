package common

typealias Point2DArray = Array<CharArray>

fun Point2DArray.print() {
    for (i in this.indices) {
        for (j in this[0].indices) {
            print(this[i][j])
            print(" ")
        }
        println()
    }
}

enum class Direction(val dX: Int, val dY: Int) {
    NORD(-1, 0),
    WEST(0, 1),
    SUDE(1, 0),
    OST(0, -1)
}
fun left(dir: Direction): Direction {
    return when(dir) {
        Direction.NORD -> Direction.OST
        Direction.OST -> Direction.SUDE
        Direction.SUDE -> Direction.WEST
        Direction.WEST -> Direction.NORD
    }
}

fun right(dir: Direction): Direction {
    return when(dir) {
        Direction.NORD -> Direction.WEST
        Direction.OST -> Direction.NORD
        Direction.SUDE -> Direction.OST
        Direction.WEST -> Direction.SUDE
    }
}

fun getSymbol(dir: Direction): Char {
    return when(dir) {
        Direction.SUDE -> 'S'
        Direction.OST -> 'O'
        Direction.WEST -> 'W'
        Direction.NORD -> 'N'
    }
}