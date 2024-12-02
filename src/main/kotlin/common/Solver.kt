package common

import _2024.Day1
import java.time.Instant

fun main() {
    val start = Instant.now().epochSecond
    Day1.result1(PART1_FILE)
    Day1.result2(PART1_FILE)
    val end = Instant.now().epochSecond
    println("Time: ${end - start} ms.")
}

private const val PART1_FILE = "src\\main\\resources\\_2024\\day1.txt"
