class Lists {
    companion object Lists {
        //can be used different types in same list it's a generic type
        val countries = listOf("Turkey", "UK", true, "Sweden", 23)
        fun lists() {
            //listof  => countries is immutable list cannot add or remove value
            println("countries: $countries")

            //mutable list can be added or removed an item
            val countriesList = countries.toMutableList()
            val randomList = mutableListOf(42, 44,11,10,5,3, 12)

            randomList.addAll( listOf(2,3,4,5))
            println("list: $randomList")

            countriesList.add("germany")
            println("countries: $countriesList")

            val fiveIsNotInList = 5 !in randomList
            println(fiveIsNotInList)

            val combinedList = randomList + countriesList
            println("combined List : $combinedList")
        }
    }
}