import kotlin.system.measureTimeMillis

fun main() {
    val day = "Day01"

    fun part1(input: List<String>): Int? = input
        .joinToString(",")
        .split(",,")
        .maxOfOrNull { it.split(",").sumOf(String::toInt) }

    fun part2(input: List<String>): Int = input
        .joinToString(",")
        .split(",,")
        .map { it.split(",").sumOf(String::toInt) }
        .sortedDescending()
        .take(3)
        .sum()

    val testInput = readInput(day + "_test")

    val input = readInput(day)
    var result: Any?

    println("Test 1 solved in ${measureTimeMillis { result = part1(testInput) }}ms with result: $result, expected: 24000")
    println("Test 2 solved in ${measureTimeMillis { result = part2(testInput) }}ms with result: $result, expected: 45000")
    println("Part 1 solved in ${measureTimeMillis { result = part1(input) }}ms with result: $result")
    println("Part 2 solved in ${measureTimeMillis { result = part2(input) }}ms with result: $result")
}
