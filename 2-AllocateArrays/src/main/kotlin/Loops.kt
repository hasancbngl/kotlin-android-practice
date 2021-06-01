class Loops {
    companion object Loop {
        fun printLoop() {

            //step means +=2
            for (i in 2..5 step 2) {
                println(i)
            }

            val rangeFromZeroToTen = 0..10 // inclusive range
            println("range $rangeFromZeroToTen")

            val exclusiveRange = 0 until 10
            println(exclusiveRange)

            for (i in 10 downTo  2 step 2) {
                println(i)
            }
        }
    }
}