data class Pet(val name: String, val animalType: String)
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
//data class has default toString and other methods  and object can be printed
data class Person(
    val name: String,
    val lastName: String?,
    var age: Int,
    val pet: Pet
) {

}

//class properties can be defined at the primary constructer using modifiers(val,var)
fun main() {
    val dog = Pet("Cuki", "German Dog")
    val hasan = Person("Hasan", "Çobanoğlu", 24, dog)
    println(hasan)
    val cuki = Pet("Cuki", "unkown")
    val olderHasan = hasan.copy(age = 28, pet = cuki)
    println(olderHasan)

    val (name, surname, _,_) = hasan
    println("$name $surname")

    //2 equals checks if the data is same, 3 eq checks if the reference is same. it's not so both are false
    println(hasan==olderHasan)
    println(hasan===olderHasan)
}