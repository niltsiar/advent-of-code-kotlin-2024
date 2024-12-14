import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (first, second) = input.map { line ->
            line.substringBefore(" ").toInt() to line.substringAfterLast(" ").toInt()
        }.unzip()

        return first.sorted().zip(second.sorted()).sumOf { (a, b) -> abs(b - a) }
    }

    fun part2(input: List<String>): Int {
        val (first, second) = input.map { line ->
            line.substringBefore(" ").toInt() to line.substringAfterLast(" ").toInt()
        }.unzip()

        return first.fold(0) { acc, a ->
            acc + a * second.count { b -> b == a }
        }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()

    check(part2(testInput) == 31)
    part2(input).println()
}
