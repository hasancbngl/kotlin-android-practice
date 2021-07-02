class Conclusion {
    companion object {
        fun conclusion() {
            /* See Dwarves below. I want them organized like this:
            - Grouped by which names come before or after M in the alphabet.
            - Sorted by name length.
            - No dwarves with names less than four letters long.
            - Turn dwarves before M into a map, grouped by the first letters in their names*/

            val lotsOfDwarves = listOf(
                listOf("Sleepy", "Grumpy", "Doc", "Bashful", "Sneezy"),
                listOf("Thorin", "Nori", "Bombur")
            )
            println(lotsOfDwarves)

            //use flatMap to flatten two lists into one list
           val (beforeM, afterM) =  lotsOfDwarves.flatMap { dwarves ->
                //using filter only return the elements meets the condition
                dwarves.filter { it.length > 3 }
            }.sortedBy { -it.length }.partition { it < "M" }
            //partition made 2 lists first elements come before "M" and the 2. come later than "M"
            println(beforeM)
            println(afterM)

            val groupedBy = beforeM.groupBy { it.first() }
            println(groupedBy)
        }
    }
}