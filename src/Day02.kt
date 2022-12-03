import kotlin.system.measureTimeMillis

fun main() {
    val day = "Day02"

    fun matchUpPoints1(letter: String): Int = when (letter) {
        "A X" -> 4
        "B X" -> 1
        "C X" -> 7
        "A Y" -> 8
        "B Y" -> 5
        "C Y" -> 2
        "A Z" -> 3
        "B Z" -> 9
        "C Z" -> 6
        else -> error("tja")
    }

    fun matchUpPoints2(letter: String): Int = when (letter) {
        "A X" -> 3
        "B X" -> 1
        "C X" -> 2
        "A Y" -> 4
        "B Y" -> 5
        "C Y" -> 6
        "A Z" -> 8
        "B Z" -> 9
        "C Z" -> 7
        else -> error("tja")
    }

    fun part1(input: List<String>): Int = input.sumOf(::matchUpPoints1)

    fun part2(input: List<String>): Int = input.sumOf(::matchUpPoints2)

    val testInput = readInput(day + "_test")

    val input = readInput(day)
    var result: Any

    println("Test 1 solved in ${measureTimeMillis { result = part1(testInput) }}ms with result: $result, expected: 15")
    println("Test 2 solved in ${measureTimeMillis { result = part2(testInput) }}ms with result: $result, expected: 12")
    println("Part 1 solved in ${measureTimeMillis { result = part1(input) }}ms with result: $result")
    println("Part 2 solved in ${measureTimeMillis { result = part2(input) }}ms with result: $result")
}
