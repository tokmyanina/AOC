package common

import _2024.Day2
import java.time.Instant

fun main() {
    val start = Instant.now().epochSecond
    Day2.result1(PART1_FILE)
    Day2.result2(PART1_FILE)
    val end = Instant.now().epochSecond
    println("Time: ${end - start} ms.")
}

private const val PART1_FILE = "src\\main\\resources\\_2024\\day2.txt"
