class Funct {

    companion object {
        fun functions() {

            fun createRange(start: Int, end: Int, isHalfOpen: Boolean = false) =
                if (isHalfOpen) start until end
                else start..end

            fun createRange(start: Char, end: Char, isHalfOpen: Boolean = false) =
                if (isHalfOpen) start until end
                else start..end

            fun printRange(range: IntRange) {
                println()
                for (number in range) print("$number \t")
                println()
            }

            fun printRange(range: CharRange) {
                println()
                for (number in range) print("$number \t")
                println()
            }

            val closedRange = createRange(1, 10)
            printRange(closedRange)

            val halfOpenRange = createRange(1, 10, true)
            printRange(halfOpenRange)

            val charRange = createRange('H', 'K')
            printRange(charRange)

            val usingNamedArg = createRange(end = 5, isHalfOpen = true, start = 2)
            printRange(usingNamedArg)

            fun calc(x: Int, y: Int) = println(x + y)
            fun calc(a: String, b: String) = println("$a $b")

            calc(3, 5)
            calc("this is", "sentence")


            fun parseCoordinates(input : String) : Pair<Double, Double> {
                val latLongitude = input.split(",")
                val latidute = latLongitude[0].toDouble()
                val longitude = latLongitude[1].toDouble()

                return latidute to longitude
            }

            val (lat,longitude) = parseCoordinates("24.18,45.15")
            println("latitude: $lat longitude : $longitude")

            fun name(firstName : String, lastName : String = "") = firstName.length + lastName.length
            fun name(firstName: String, lastName: String = "", middleName: String = "") = "$firstName$middleName$lastName".length

           val myNameLength =  name("Hasan", "Çobanoğlu")
            println(myNameLength)

            val philips = name(lastName = "eduardoo" , firstName= "Philip", middleName = "alli")
            println(philips)
        }
    }
}