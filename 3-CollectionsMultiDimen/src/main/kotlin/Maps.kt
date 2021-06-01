class Maps {
    companion object {
        val bookCollection = mutableMapOf<String, MutableList<String>>()

        fun addValues() {
            bookCollection["oguzAtay"] = mutableListOf("Tutunamayanlar", "Tehlikeli oyunlar")
            bookCollection["Dostoyevsky"] = mutableListOf("idiot", "Notes from Underground")
            println(bookCollection)

            val books = bookCollection["oguzAtay"]
            println(books)

            //immutable maps can not be changed
            val authenticationHeaders = mapOf(
                "API_KEY" to "your-api-key",
                "Authorization" to "auth token",
                "content/type" to "application/json"
            )
            //can not be changed
            //  authenticationHeaders["API_KEY"] = "aa"
            //in order to change any value had to use mutableMapOf
            println(authenticationHeaders)

            bookCollection["camus"] = mutableListOf("the stranger")
            println(bookCollection)

            bookCollection["camus"]?.add("The myth of syisyphus")
            println(bookCollection)

            println(bookCollection.remove("oguzAtay"))
            println(bookCollection)

            println("\n\n--------------")

            for (key in bookCollection.keys) {
                println("key : $key")
            }

            for(values in bookCollection.values) println("value: $values")

            for ((key, value) in bookCollection) println("key: $key , value : $value")
        }
    }
}