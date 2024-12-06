package common

import java.io.File
import java.io.InputStream

fun readStrings(filename: String): List<String> {
    val inputStream: InputStream = File(filename).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    return lineList
}

fun readString(filename: String): String {
    val inputStream: InputStream = File(filename).inputStream()
    return inputStream.bufferedReader().readLine()
}

fun<T> parseStrings(filename: String, parse: (String) -> T): List<T> {
    return readStrings(filename).map { s ->  parse(s)}
}

fun<T> readDataAsTwoList(filename: String, parse: (String) -> List<T>) : Pair<List<T>, List<T>> {
    val first = mutableListOf<T>()
    val second = mutableListOf<T>()

    parseStrings(filename, parse)
        .map {
            first.add(it[0])
            second.add(it[1])
        }

    return Pair(first, second)
}

fun <T> getResultByLine(fileName: String, solve: (String) -> T ) {
    val data = readString(fileName)
    println(solve(data))
}

fun<T> getParsedSumOfResults(fileName: String, parse: (String) -> T, solve: (T) -> Int) {
    println(parseStrings(fileName, parse)
        .sumOf(solve))
}

fun<T> getParsedCountOfResults(fileName: String, parse: (String) -> T, check: (T) -> Boolean) {
    println(parseStrings(fileName, parse)
        .count { check(it) })
}

fun readDataAs2DArray(filename: String, border: Int = 0, borderSymbol: Char = '#'): Point2DArray {
    val data = readStrings(filename)
    val rows = data.size + border * 2
    val cols = data[0].length + border * 2
    var result = emptyArray<CharArray>()
    for (i in 0 until rows) {
        val row = if (i < border || i >= data.size + border) {
            CharArray(cols) {borderSymbol}
        }
        else {
            CharArray(cols) {
                col -> if (col < border || col >= cols - border) {
                    borderSymbol
                }
                else {
                    data[i - border][col - border]
                }
            }
        }
        result += row
    }
    return result
}