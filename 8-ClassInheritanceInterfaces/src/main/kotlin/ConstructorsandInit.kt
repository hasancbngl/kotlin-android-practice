data class Grade2(val courseName: String, val letter: Char)

open class Student2(
    var firstName: String, var lastName: String,
    var grades: MutableList<Grade> = mutableListOf<Grade>()
) {
    open fun recordGrade(grade: Grade) {
        grades.add(grade)
    }
}

class BandMember2(firstName: String, lastName: String) : Student2(firstName, lastName) {
    var minimumPracticeTime: Int = 2
    val isEligible
        get() = grades.none { it.letter == 'F' }

    //alternate constructor and also called secondary
    constructor(firstName: String, lastName: String, minimumPracticeTime: Int) : this(firstName, lastName) {
        //that's an initblock
        this.minimumPracticeTime = minimumPracticeTime
    }

    constructor(transfer: BandMember2) : this(transfer.firstName, transfer.lastName, transfer.minimumPracticeTime) {
        grades = transfer.grades
        if (!isEligible) minimumPracticeTime += 2
        println("(transfer contructor) practise for ${minimumPracticeTime} hours!")
    }

    init {
        //init block run after the primary constructor call and before the code in secondary constructor
        if (!isEligible) minimumPracticeTime += 2
        println("(init) practise for ${minimumPracticeTime} hours!")
    }

    init {
        //init block run after the primary constructor call and before the code in secondary constructor
        if (!isEligible) minimumPracticeTime += 2
        println("(init 2) practise for ${minimumPracticeTime} hours!")
    }
}

fun main() {
    val bill = BandMember2(firstName = "Bill", lastName = "Rest")

    bill.recordGrade(Grade("Math", 'B', 5.0))
    bill.recordGrade(Grade(courseName = "Guitar 101", letter = 'F', 2.0))

    val transferredBill = BandMember2(bill)
    println(transferredBill.grades)


    val ted = BandMember2(firstName = "Ted", lastName = "Seq Logan", minimumPracticeTime = 7)
}