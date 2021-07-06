/*
Challenge 1 - Building a Class Hierarchy
Create a class named `Animal` that has…
1. a method named `speak()` that does nothing.
Create two `Animal` subclasses...
1. `WildAnimal` that...
  - has an `isPoisonous` property, that is a `Boolean`
2. `Pet` that...
  - has a stored property named `name`, that is a `String`
  - has a `play()` method that prints out a message
  - overrides `speak()` - It should print out a message
Create one subclass of your choice of `WildAnimal` or `Pet`. It should do at least one of the following:
 - override `speak()`
 - override `play()`
 - Add a new property with custom accessor
 - Add a new method
*/

open class Animal {
    open fun speak() {}
}

class WildAnimal(val isPoisonus: Boolean) : Animal()

open class Pet(val name: String) : Animal() {
    open fun play() {
        println("Play time!!")
    }

    override fun speak() {
        println("Hi, I'm $name! ")
    }
}

class Dog(val age: Int, name: String) : Pet(name) {
    override fun speak() {
        println("I'm $name. Don't worry I don't bite. ")
    }

    override fun play() {
        println("Play with the ball")
    }

    fun willLive5X() {
        println("$name will live ${5 * age} years!!")
    }
}


/*
Challenge 2 - Overriding & Polymorphism
- Write a function that takes an `Animal` and does something different depending on what subclass it is.
  You'll need to do some safe casting and null checks!
- Create at least one instance of each class from the first challenge.
- Create an array that contains all of the instances.
- Call the function with each of your instances using a loop or whatever other method you'd like!
*/

fun main() {

    fun checkPrintAnimal(animal: Animal) {
        when {
            (animal as? WildAnimal) != null -> println(
                if (animal.isPoisonus) "It can kill ya!"
                else "It's not poisonus at all!"
            )
            animal is Dog -> {
                println("${animal.name} gonna stay with me!")
                animal.speak()
            }
            (animal as? Pet) != null -> {
                println("This is definitely a normal sort of pet and I've named them ${animal.name}")
                animal.speak()
                animal.play()
            }
            else -> println("It's animal the one you know which lives in jungle :)")
        }
    }

    val animal = Animal()
    val babyAragol = WildAnimal(isPoisonus = true)
    val babySmaug = WildAnimal(isPoisonus = false)
    val jackie = Pet(name = "Jackie")
    val jax = Dog(name = "Jax", age = 2)

    val animals = arrayOf(animal, babyAragol, babySmaug, jackie, jax)
    animals.forEach { checkPrintAnimal(it) }
}