import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("input", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

typealias IntRangePair = Pair<IntRange, IntRange>

fun IntRangePair.rangeContains() =
    ((first.first in second) && (first.last in second)) || ((second.first in first) && (second.last in first))

fun IntRangePair.rangeOverlaps() =
    first.first in second || first.last in second || second.first in first || second.last in first
