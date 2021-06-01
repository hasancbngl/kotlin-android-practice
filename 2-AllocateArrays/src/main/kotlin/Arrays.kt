class Arrays {
    companion object Arr {
        //cannot add or remove values form the coll array
        val visitedCountries = arrayOf("Romania", "MAcedonia", "Albania", "Croatia", "Bulgaria")

        fun printArr() {
            println(visitedCountries[2])

            val sizedArray = Array(10) { "" } // 10 empty strings
            val emptyArray = emptyArray<String>() // no elements

            val arrayOfInts = intArrayOf(2, 3, 4, 5, 6, 7)
            println(arrayOfInts[2])
            println("sized array ${sizedArray[2]}")

            val country = "Turkey"
            // short syntax of visitedCountries.contains(country)
            val visitedTurkey = country in visitedCountries

            println(visitedTurkey)

            for(item in visitedCountries) {
                println("visited country: $item")
            }

        }
    }
}