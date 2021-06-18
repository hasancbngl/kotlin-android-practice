class Pet(var name: String, val animalType: String)
class Movie(private var name: String, private var year: Int, private var genre: String) {
    fun getData() = "$name, $year, $genre"
    fun changeYear(year: Int) {
        this.year = year
    }
    fun changeData(name: String, genre: String) {
        this.name = name
        this.genre = genre
    }
}

class Person(
    private val name: String,
    private val lastName: String?,
    private var age: Int,
    val pet: Pet
) {
    fun setAge(age: Int) {
        if (age in 0..100) {
            this.age = age
        } else {
            //invalid age
        }
    }

    fun getAge() = age

    fun getFullInfo(): String {
        return "Name: ${name}, Last name: $lastName Age: $age, pet: ${pet.name}, ${pet.animalType}"
    }
}

//class properties can be defined at the primary constructer using modifiers(val,var)

fun main() {
    var lucie = Pet("lucia", "cat")
    val hasan = Person("hasan", "Çobanoğlu", 24, lucie)
    println(hasan.getFullInfo())
    hasan.setAge(25)
    println(hasan.getAge())

    println(hasan.pet.name)

    lucie.name = "Scratchy"
    println(hasan.pet.name)

    lucie = Pet("Jura", "Goldie")
    println(hasan.pet.name)

    /* val hasan = Person("hasan", "Çobanoğlu", 24)
     //   hasan.age = 24
     // hasan.lastName = "Çobanoğlu"
     // hasan.name = "hasan"

     println(hasan)
     println("Name: ${hasan.name}, Last name: ${hasan.lastName} Age: ${hasan.age}")
     val lisa = Person("Lİsa", null, 24)
     println("Name: ${lisa.name}, Last name: ${lisa.lastName} Age: ${lisa.age}")*/

    val punisher = Movie("Punisher", 2017, "action")
    println(punisher.getData())
    punisher.changeYear(2018)
    println(punisher.getData())
}