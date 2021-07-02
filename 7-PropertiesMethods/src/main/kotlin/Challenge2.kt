import kotlin.properties.Delegates

class Challenge2 {
    /* Challenge 1:
     Rewrite the `IceCream` class below:
    1. Use a default value for the name property.
    2. Lazily initialize the `ingredients` list. */

    class IceCream {
        var name: String = "Vanilla"
        val ingredients: ArrayList<String> by lazy {
            arrayListOf()
        }
    }

    /* Challenge 2:
       Below is a `SpaceCar` and `SpaceBattery` class.
       Dive into the inner workings of the car and rewrite the `SpaceBattery` class
        below with delegated property observer functionality:
        1. Add a `lowCharge` property of Boolean type to the class.
        2. Flip the `lowCharge` Boolean when the `level` drops below 10%.
        3. Ensure that when the tank fills back up, the `lowCharge` warning will turn off.
        4. Add a `SpaceBattery` property to `SpaceCar`, make one, and charge it up. Then fly around for awhile. */

    class SpaceCar(
        val make: String,
        val color: String,
        var spaceBattery: SpaceBattery = SpaceBattery()
    )

    class SpaceBattery {
        var lowCharge = true
        var level: Double by Delegates.observable(0.0) { _, _, new ->
            lowCharge = new <= 0.1
        }

    }

    companion object {
        fun main() {
            // ~~~Challenge 1~~~
            // Make a new instance of IceCream
            val peanut = IceCream()
            println(peanut.name)
            // Give it a name other than the default
            peanut.name = "peanut ice cream"
            println(peanut.name)
            // Add some ingredients!
            peanut.ingredients.add("peanut")
            peanut.ingredients.add("vanilla")
            peanut.ingredients.add("sugar")
            println(peanut.ingredients)

            // ~~~Challenge 2~~~
            // Make a SpaceCar!
            val myCar = SpaceCar("Elisa", "blue")
            // Charge the battery!
            myCar.spaceBattery.level = 1.0
            println("low battery: ${myCar.spaceBattery.lowCharge}")
            // Fly around for awhile.
            myCar.spaceBattery.level = 0.02
            println("low battery: ${myCar.spaceBattery.lowCharge}")
        }
    }
}