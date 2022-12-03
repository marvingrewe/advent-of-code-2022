import kotlin.system.measureTimeMillis

fun main() {
    val day = "Day03"

    fun Char.priority() = when (code) {
        in 'a'.code..'z'.code -> (code - 'a'.code) + 1
        in 'A'.code..'Z'.code -> (code - 'A'.code) + 27
        else -> error("no priority for $this")
    }

    fun part1(input: List<String>): Int = input
        .sumOf {
            it.chunked(it.length / 2, CharSequence::toSet)
                .reduce(Set<Char>::intersect)
                .single()
                .priority()
        }

    fun part2(input: List<String>): Int = input
        .chunked(3)
        .sumOf {
            it.map(String::toSet)
                .reduce(Set<Char>::intersect)
                .single()
                .priority()
        }

    val testInput = readInput(day + "_test")

    val input = readInput(day)
    var result: Any

    println("Test 1 solved in ${measureTimeMillis { result = part1(testInput) }}ms with result: $result, expected: 157")
    println("Test 2 solved in ${measureTimeMillis { result = part2(testInput) }}ms with result: $result, expected: 70")
    println("Part 1 solved in ${measureTimeMillis { result = part1(input) }}ms with result: $result")
    println("Part 2 solved in ${measureTimeMillis { result = part2(input) }}ms with result: $result")
}
