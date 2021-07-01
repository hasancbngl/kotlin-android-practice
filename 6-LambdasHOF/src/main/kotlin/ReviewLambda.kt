class ReviewLambda {
    companion object {
        fun lambdaReview() {

            fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
                return operation(a, b)
            }

            val addLambda = { a: Int, b: Int -> a + b }

            val substractNum = { a: Int, b: Int -> a - b }

            println(operateOnNumbers(5, 8, addLambda))
            println(operateOnNumbers(5, 8, Int::plus)) //using function reference
            println(operateOnNumbers(5, 8, substractNum))
            println(operateOnNumbers(5, 8, operation = { a: Int, b: Int -> a * b }))

            fun divide(a: Int, b: Int) = a / b
            println(operateOnNumbers(20, 3, ::divide))
        }
    }
}