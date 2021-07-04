data class Grade(val courseName: String, val letter: Char, val credits: Double)

open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student(
    firstName: String, lastName: String,
    var grades: MutableList<Grade> = mutableListOf<Grade>()
) : Person(firstName, lastName) {

    fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember(firstName: String, lastName: String) : Student(firstName, lastName) {
    var minimumPractiseTime: Int = 3
}

class StudentAthlete(firstName: String, lastName: String) : Student(firstName, lastName) {
    var isEligible = false
}

fun main() {
    val jon = Person(firstName = "Jon", lastName = "Snow")
    val jane = Student(firstName = "Jane", "Snane")
    val victor = StudentAthlete("Victor", "Brook")
    val marty = BandMember("Marty", "Els")

    println(jane.fullName())
    println(jon.fullName())
    println("${marty.fullName()} practises for ${marty.minimumPractiseTime} hours!")
    println("Can ${victor.fullName()}  play in the game : ${victor.isEligible}")

    val robotics = Grade(courseName = "Robotics", letter = 'A', credits = 3.0)
    jane.recordGrade(robotics)
    println(jane.grades)
}