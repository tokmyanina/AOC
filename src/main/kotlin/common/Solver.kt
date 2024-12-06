package common

import _2024.Day6
import java.time.Instant

fun main() {
    val start = Instant.now().toEpochMilli()
    Day6.result1(PART1_FILE)
    Day6.result2(PART1_FILE)
    val end = Instant.now().toEpochMilli()
    println("Time: ${end - start} ms.")
}

private const val PART1_FILE = "src\\main\\resources\\_2024\\day6.txt"
