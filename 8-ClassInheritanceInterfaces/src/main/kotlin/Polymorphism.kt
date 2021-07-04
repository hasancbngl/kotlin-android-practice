fun main() {
    val jon = Person(firstName = "Jon", lastName = "Snon")
    val jane = Student(firstName = "Jane", lastName = "Snane")
    val victor = BandMember("Victor", "Wooten")
    val marty = StudentAthlete("Marty", "McWolf")

    val persons: Array<Person> = arrayOf(jon, jane, victor, marty)
    val students: Array<Student> = arrayOf(jane, victor, marty)

    persons.forEach { person ->
        println("${person.fullName()} is a person!")
        if (person is Student) println("${person.grades} has a grades!")
        // checking if person object if is a student. all students are inherited from Person
        // class but Person class doesnt have grade property
        //will mot work to call    person.grade
    }

    //casting victor Band member object to Student object (band member inherited form Student so it's a student)
    //down casting student to BandMember that is nullable

    val student = victor as Student
    val bassist = student as? BandMember

    //overloading to have the same function with the same name but different parameters

    fun afterClassActivity(student: Student) : String {
        return "Goes Home!"
    }

    fun afterClassActivity(student: BandMember) : String {
        return "Practises for ${student.minimumPractiseTime} hours!"
    }

    println(afterClassActivity(victor))
    //after casting afterClassActivity() student version will be called
    println(afterClassActivity(victor as Student))
}
