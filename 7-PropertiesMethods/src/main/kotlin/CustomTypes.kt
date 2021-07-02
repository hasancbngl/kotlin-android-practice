import kotlin.math.roundToInt
import kotlin.math.sqrt

class CustomTypes {
    class Person(private val firstName: String, private val lastName: String) {
        val fullName = "$firstName $lastName"
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
        val boss: String,
        var unlocked: Boolean
    ) {
        companion object {
            //highesr level property on level itself so can not be accesed from instance
            var highestLevel = 1
        }
    }

    companion object {

        fun costomType() {
/*            val grace = Person("Grace", "Hopper")
            println(grace.fullName)*/

            val level1 = Level(1, "Outside Cat", true)
            val level2 = Level(id = 2, boss = "Laser Pointer", unlocked = false)
            val level3 = Level(id = 3, boss = "Mysterious Attic Sound", unlocked = false)
            val level4 = Level(id = 4, boss = "Vacuum Cleaner", unlocked = false)

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