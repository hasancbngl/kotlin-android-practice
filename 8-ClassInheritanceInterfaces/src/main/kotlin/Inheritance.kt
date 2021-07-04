data class Grade(val courseName: String, val letter: Char, val credits: Double)

open class Person(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
}

open class Student(
    firstName: String, lastName: String,
    var grades: MutableList<Grade> = mutableListOf<Grade>()
) : Person(firstName, lastName) {
    open var isEligible = true

    //open fun means a function can be overridden by subclass
    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember(firstName: String, lastName: String) : Student(firstName, lastName) {
    var minimumPractiseTime: Int = 3

    override var isEligible: Boolean = true
        //none will return true if none of the grades match the condition
        get() = grades.none() { it.letter == 'F' }

    override fun recordGrade(grade: Grade) {
        //super.record means does what  usually does in this case adding the grade to grades property.
        super.recordGrade(grade)
        if (!isEligible) println("No more performing for  ${fullName()}! Study, Study, Study.")
    }
}

class StudentAthlete(firstName: String, lastName: String) : Student(firstName, lastName) {

    override fun recordGrade(grade: Grade) {
        //super.record means does what  usually does in this case adding the grade to grades property.
        super.recordGrade(grade)
        isEligible = grades.filter { it.letter == 'F' }.size < 3
        if (!isEligible) println("${fullName()} Can't play in the big game! Time to study more.")
    }
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

    val utterFaliureGrade = Grade("Being a regular Human", 'F', 2.0)
    victor.recordGrade(utterFaliureGrade)
    victor.recordGrade(utterFaliureGrade)
    victor.recordGrade(utterFaliureGrade)

    println(victor.grades)
    marty.recordGrade(utterFaliureGrade)
    println("${marty.fullName()} is eligible ${marty.isEligible}")
}