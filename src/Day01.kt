import kotlin.math.max
import kotlin.system.measureTimeMillis

fun main() {
    fun part1(input: List<String>): Int {
        val (_, max) = input.fold(0 to 0) { (current, max), element ->
            when (element.isNotEmpty()) {
                true -> current + element.toInt() to max(current + element.toInt(), max)
                false -> 0 to max
            }
        }
        return max
    }

    fun part2(input: List<String>): Int {
        val modifiedInput = input + ""
        val (_, triple) = modifiedInput.fold(0 to listOf(0, 0, 0)) { (current, currentMax), element ->
            when (element.isNotEmpty()) {
                true -> current + element.toInt() to currentMax
                false -> 0 to listOf(current, *currentMax.toTypedArray()).sorted().drop(1)
            }
        }
        return triple.toList().sum()
    }

    val testInput = readInput("Day01_test")

    val input = readInput("Day01")
    var result: Any

    println("Test 1 solved in ${measureTimeMillis { result = part1(testInput) }}ms with result: $result, expected: 24000")
    println("Test 2 solved in ${measureTimeMillis { result = part2(testInput) }}ms with result: $result, expected: 45000")
    println("Part 1 solved in ${measureTimeMillis { result = part1(input) }}ms with result: $result")
    println("Part 2 solved in ${measureTimeMillis { result = part2(input) }}ms with result: $result")
}
