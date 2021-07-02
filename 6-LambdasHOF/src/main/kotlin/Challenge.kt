class Student(val name: String, var grade: Int, var pet: String?, var libraryBooks: List<String>) {
    fun getPassStatus(lowestPass: Int = 50) {
        grade >= lowestPass
    }

    fun earnExtraCredit() {
        grade += 10
    }
}


val chris = Student(
    name = "Chris", grade = 49, pet = "Mango",
    libraryBooks = listOf("The Book of Atrus", "Living by the Code", "Mastering Git")
)
val sam = Student(
    name = "Sam", grade = 99, pet = null,
    libraryBooks = listOf("Mastering Git")
)
val catie = Student(
    name = "Catie", grade = 75, pet = "Ozma",
    libraryBooks = listOf("Hogfather", "Good Omens")
)
val andrea = Student(
    name = "Andrea", grade = 88, pet = "Kitten",
    libraryBooks = listOf("Dare to Lead", "The Warrior's Apprentice")
)
val students = arrayOf(chris, sam, catie, andrea)

class Challenge {
    companion object {
        fun challenge() {
            /*:
            Challenge 1 - `forEach` & `map`
            There are two `for` loops below.
            Rewrite one of them using `forEach` and the other with `map` */

            for (student in students) {
                student.earnExtraCredit()
            }
            //with forEach
            students.forEach { student ->
                println("old grade: ${student.grade}")
                student.earnExtraCredit()
                println("new grade: ${student.grade}")
            }
            // students.forEach { it.earnExtraCredit() }

            val classLibraryBooks: MutableList<List<String>> = mutableListOf()
            for (student in students) {
                classLibraryBooks.add(student.libraryBooks)
            }
            println(classLibraryBooks)
            val classLibraryBooks2 = students.map { it.libraryBooks }
            println(classLibraryBooks2)


            /*:
             Challenge 2 - mapNotNull
            Create a list of student pets */
            //mapnotnull throw the null values
            val petList = students.mapNotNull { it.pet }
            val petList2 = students.map { it.pet }
            println(petList2)
            println(petList)
        }
    }
}