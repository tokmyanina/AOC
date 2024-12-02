package common

import java.security.MessageDigest

fun md5AsString(array: ByteArray): String {
    return array.joinToString(separator = "") { byte -> "%02x".format(byte) }
}

fun md5(input: String): ByteArray {
    val md = MessageDigest.getInstance("MD5")
    return md.digest(input.toByteArray())
}

fun md5HasLeadingZeroes(array: ByteArray, count: Int): Boolean {
    var result = 0
    for (b in array) {
        var endsWithZero = false
        val cur = "%02x".format(b)
        if (cur == "00") {
            result+= 2
            endsWithZero = true
        }
        else if (cur[0] == '0') {
            result ++
        }
        if (!endsWithZero || result >= count) break
    }
    return result >= count
}