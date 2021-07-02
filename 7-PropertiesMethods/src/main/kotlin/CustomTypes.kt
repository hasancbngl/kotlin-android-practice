import kotlin.math.roundToInt
import kotlin.math.sqrt

class CustomTypes {
    class Person(private val firstName: String, private val lastName: String) {
        val fullName = "$firstName $lastName"
    }

    class TV(var width: Double, var height: Double) {
        var diagnal: Int
            get() {
                val result = sqrt(width * width + height * height)
                return result.roundToInt()
            }
            set(value) {
                val ratioWidth = 16.0
                val ratioHeight = 9.0
                val ratioDiagnoal = sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
                height = value.toDouble() * ratioHeight / ratioDiagnoal
                width = height * ratioWidth / ratioHeight
            }
    }

    companion object {

        fun costomType() {
            val grace = Person("Grace", "Hopper")
            println(grace.fullName)

            val tv = TV(width = 85.3, height = 45.454)
            println(tv.diagnal)
            tv.width = tv.height
            println(tv.diagnal)
            tv.diagnal = 65
            println("That'll be ${tv.width} inches wide!")
        }
    }
}