import kotlin.math.atan
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.properties.Delegates

class CustomTypes {
    class Circle(var radius: Double = 0.0) {
        val pi: Double by lazy {
            ((4.0 * atan(1.0 / 5.0)) - atan(1.0 / 239.0)) * 4.0
        }
        val circumference: Double
            get() = pi * radius * 2
    }

    class Person(private val firstName: String, private val lastName: String) {
        val fullName = "$firstName $lastName"
    }

    class Lamp {
        lateinit var lightBulb: LightBulb
    }

    class TVMath() {
        companion object {
            fun getDiagnol(width: Double, height: Double): Int {
                val result = sqrt(width * width + height * height)
                return result.roundToInt()
            }

            fun getWidthAndHeight(diagnol: Int, ratioWidth: Double, ratioHeight: Double): Pair<Double, Double> {
                val ratioDiagnoal = sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
                val height = diagnol.toDouble() * ratioHeight / ratioDiagnoal
                val width = height * ratioWidth / ratioHeight
                return Pair(width, height)
            }
        }
    }

    class TV(var width: Double, var height: Double) {
        var diagnal: Int
            get() {
                return TVMath.getDiagnol(width, height)
            }
            set(value) {
                val (widthSize, heightSize) = TVMath.getWidthAndHeight(
                    diagnol = value,
                    ratioWidth = 16.0,
                    ratioHeight = 9.0
                )
                width = widthSize
                height = heightSize
            }
    }

    class Level(
        val id: Int,
        val boss: String
    ) {
        companion object {
            //highesr level property on level itself so can not be accesed from instance
            var highestLevel = 1
        }

        //listen to changes to unclocked via observable then update the highestlevel
        var unlocked: Boolean by Delegates.observable(false) { _, old, new ->
            if (new && id > highestLevel) {
                println("old : $old, new: $new")
                highestLevel = id
            }
        }
    }

    class LightBulb {
        companion object {
            const val maxCurrent = 40
        }

        var current by Delegates.vetoable(20) { _, _, new ->
            if (new > maxCurrent) {
                //dont change it
                println("Current too high, falling back to previous value")
                false
            } else { //change it
                true
            }
        }
    }

    companion object {

        fun costomType() {
            val circle = Circle(5.8)
            println(circle.circumference)

            val light = LightBulb()
            println("current: ${light.current}")
            light.current = 9812
            println("current: ${light.current}")
            light.current = 40
            println("current: ${light.current}")

            val fancyLamp = Lamp()
            fancyLamp.lightBulb = light
            println("liggght: Bulb =>  ${fancyLamp.lightBulb.current}")

/*           val grace = Person("Grace", "Hopper")
            println(grace.fullName)*/

            val level1 = Level(1, "Outside Cat")
            val level2 = Level(id = 2, boss = "Laser Pointer")
            val level3 = Level(id = 3, boss = "Mysterious Attic Sound")
            val level4 = Level(id = 4, boss = "Vacuum Cleaner")

            level1.unlocked = true
            println("Highest LEvel is: ${Level.highestLevel}")
            level3.unlocked = true
            println("Highest LEvel is: ${Level.highestLevel}")

            val tv = TV(width = 85.3, height = 45.454)
            println(tv.diagnal)
            tv.width = tv.height
            println(tv.diagnal)
            tv.diagnal = 65
            println("That'll be ${tv.width} inches wide!")
        }
    }
}