class SetsA {
    companion object {
        //a set holds unique values (example if numbers 1,1,2,2,3
        // can not contain double 2,3 so it'll be => 1,2,3) can not fetch data form a set
        //if we want to change values use mutable set

        val iD = setOf("id1", "id2", "id3", "id4")
        val letters = mutableSetOf("a", "b", "d", "f")
        fun print() {
            println(iD.contains("id"))
            println("id4" in iD)

            letters.add("aa")
            letters.remove("a")
            println(letters)

            if(letters.add("b")) println("value addedd!!")
            else println("it exist")

            val numbers = arrayOf(2,3,55,66,77,42,3,3,2,2,55,66,98)
            println(numbers)
            //convert numbers into set
            val uniqueNumbers = numbers.toSet()
            println(uniqueNumbers)
        }

    }
}