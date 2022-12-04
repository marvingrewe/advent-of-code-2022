import kotlin.system.measureTimeMillis

fun main() {
    val day = "Day04"

    fun toRange(it: String) = it.split("-").map(String::toInt).let { (lower, upper) -> lower..upper }

    fun List<String>.checkRangesFor(rangePredicate: (IntRangePair) -> Boolean) = count {
        it.split(",").map(::toRange).let { (left, right) -> rangePredicate(left to right) }
    }

    fun part1(input: List<String>): Int {
        return input.checkRangesFor(IntRangePair::rangeContains)
    }

    fun part2(input: List<String>): Int {
        return input.checkRangesFor(IntRangePair::rangeOverlaps)
    }

    val testInput = readInput(day + "_test")

    val input = readInput(day)
    var result: Any

    println("Test 1 solved in ${measureTimeMillis { result = part1(testInput) }}ms with result: $result, expected: 2")
    println("Test 2 solved in ${measureTimeMillis { result = part2(testInput) }}ms with result: $result, expected: 4")
    println("Part 1 solved in ${measureTimeMillis { result = part1(input) }}ms with result: $result")
    println("Part 2 solved in ${measureTimeMillis { result = part2(input) }}ms with result: $result")
}
