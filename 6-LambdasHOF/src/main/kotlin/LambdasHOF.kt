class LambdasHOF {
    companion object {
        fun main() {
            var counter = 0
            val incrementCounter = {
                counter += 1
            }

            incrementCounter()
            incrementCounter()
            incrementCounter()
            println("counter: $counter")

            fun countingLambda(): () -> Int {
                var counter = 0
                val incrementCounter: () -> Int = {
                    counter++
                    counter
                }
                return incrementCounter
            }

            println("countinglambda" + countingLambda())

            val counter1 = countingLambda()
            val counter2 = countingLambda()

            println("counter1: " + counter1())
            println(counter1())
            println(counter1())
            println(counter1())

            println("counter2: " + counter2())
            println(counter2())
            println(counter2())
        }
    }
}