package common

fun String.countOfVowels(): Int {
    return this.count { it.isVowel() }
}