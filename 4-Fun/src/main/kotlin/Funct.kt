class Funct {

    companion object {
        fun functions() {

            fun createRange(start: Int, end: Int, isHalfOpen: Boolean = false): IntRange {
                return if (isHalfOpen) start until end
                else start..end
            }

            fun printRange(range: IntRange) {
                println()
                for (number in range) print("$number \t")
            }

            val closedRange = createRange(1, 10)
            printRange(closedRange)

            val halfOpenRange = createRange(1, 10, true)
            printRange(halfOpenRange)

            val usingNamedArg = createRange(end = 5, isHalfOpen = true, start = 2)
            printRange(usingNamedArg)

        }
    }
}