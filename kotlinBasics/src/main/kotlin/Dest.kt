class Dest {
    /**
     * Pairs and triples
     *  Destructiring example
     * */
    companion object Example {
        val fullName = Pair<String, String>("Hasan", "Cobanoglu")

        val yearOfBirth = Triple(28, 7, 1997)
        var person = Pair(fullName, yearOfBirth)

        fun print() {
            //using _ we can omit the values we dont care about ex: day
            var (name, bday) = person
            var (month, _ , year) = bday
            var (fname, surname) = name
            println("my name is $fname, $surname, borned on  $month $year")
        }
    }
}