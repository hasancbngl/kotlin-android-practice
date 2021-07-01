class Review {
    companion object {
        fun review() {
            fun printRange() {
                for (number in 1..5) print("number $number \t")
                println()
            }
            printRange()

            fun printRange(range: IntRange) {
                for (number in range) print("number $number \t")
                println()
            }
            printRange(10..20)

            fun createRange(start: Int, end: Int, isHalfOpen: Boolean) = if (isHalfOpen) start until end
            else start..end

            val halfOpenRange = createRange(2, 6, true)
            printRange(halfOpenRange)

            val namedArgs = createRange(end = 8, start = 5, isHalfOpen = false)
            printRange(namedArgs)

            fun createRange(start: Char, end: Char, isHalfOpen: Boolean = false) =
                if (isHalfOpen) start until end else start..end

            fun printRange(range: CharRange) {
                for (key in range) print("letter: $key \t")
                println()
            }

            printRange(createRange('a', 'h'))

        }
    }
}