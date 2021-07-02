class ForEachMap {
    companion object {
        fun forEachMapExamples() {
            var prices = arrayOf(1.50, 10.00, 4.99, 2.30, 8.19)
            // `forEach` - Loops over a collection and performs an operation
            // `forEach` as a `for` loop

            //  for (price in prices) println("price (for loop) : $price")
            //  prices.forEach { price -> println("price (forEach): $price") }

            //using ::println (reference for the println fun to print each element
            //forEach returns nothing. map returns new array
            //  prices.forEach(::println)
            // prices.forEach {println(it*2) }

            //  var salePrices = mutableListOf<Double>()
            // for (price in prices) salePrices.add(price * 0.90)
            //val salePrices = prices.map { price -> price * 0.9 }
            //shorter version it means each element in the prices array
            val salePrices = prices.map { it * 0.9 }

            //print
            println(salePrices)
            // for (i in 0..salePrices.lastIndex) println(salePrices.get(i))

            val userInput = listOf("meow!", "15", "37.5", "seven", "42")
            //transfrom to int or null
            val numbers = userInput.map { it.toIntOrNull() }
            println(numbers)

            //filter the null values
            val validInput = userInput.mapNotNull { it.toIntOrNull() }
            println(validInput)
        }
    }
}