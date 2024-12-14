import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val reports = input.map { line ->
            line.split(" ").map { it.toInt() }
        }

        return reports.count { report ->
            val possiblySafe = report == report.sorted() || report == report.sortedDescending()

            possiblySafe && report.zipWithNext { a, b -> abs(b - a) in 1..3 }.all { it }
        }
    }

    fun part2(input: List<String>): Int {
        val reports = input.map { line ->
            line.split(" ").map { it.toInt() }
        }

        return reports.count { report ->
            report.indices.any { i ->
                val filtered = report.filterIndexed { index, _ -> i != index }

                val possiblySafe = filtered == filtered.sorted() || filtered == filtered.sortedDescending()

                possiblySafe && filtered.zipWithNext { a, b -> abs(b - a) in 1..3 }.all { it }
            }
        }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()

    check(part2(testInput) == 4)
    part2(input).println()
}
