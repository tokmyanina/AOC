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

