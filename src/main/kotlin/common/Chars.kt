package common

fun Char.isVowel(): Boolean {
    return when(this) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
}