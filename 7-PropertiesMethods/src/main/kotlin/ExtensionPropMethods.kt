import java.lang.Math.PI
import kotlin.math.roundToInt
import kotlin.math.sqrt

class ExtensionPropMethods {
    companion object {
        class Circle(var radius: Double = 0.0) {
            val circumference: Double
                get() = PI * radius * 2
        }

        // Add Circle Extension Property
        val Circle.diameter: Double
            get() = 2.0 * radius

        class SimpleDate(var month: String) {
            fun monthsUntilJingleBells(): Int {
                return months.indexOf("December") - months.indexOf(month)
            }

            companion object {
                val months = arrayOf(
                    "January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"
                )
            }
        }

        // Add SimpleDate Extension Method
        fun SimpleDate.monthsUntilHalloween(): Int {
            val currentMonth = SimpleDate.months.indexOf(month)
            val halloweenStart = SimpleDate.months.indexOf("September")
            val halloweenEnd = SimpleDate.months.indexOf("October")
            return if (currentMonth in 0..halloweenStart) {
                halloweenStart - currentMonth
            } else if (currentMonth in halloweenStart..halloweenEnd) 0
            else {
                halloweenStart + (12 - currentMonth)
            }
        }

        class TVMath {
            companion object {
                fun getDiagonal(width: Double, height: Double): Int {
                    val result = sqrt(width * width + height * height)
                    return result.roundToInt()
                }

                fun getWidthAndHeight(diagonal: Int, ratioWidth: Double, ratioHeight: Double): Pair<Double, Double> {
                    val ratioDiagonal = sqrt(ratioWidth * ratioWidth + ratioHeight * ratioHeight)
                    val height = diagonal * ratioHeight / ratioDiagonal
                    val width = height * ratioWidth / ratioHeight

                    return Pair(width, height)
                }
            }
        }

        // Add TVMath Companion Object Extension Method
        fun TVMath.Companion.idealViewingDistance(diagonal: Int, is4K: Boolean): Double {
            return if(is4K) diagonal * 1.25 else diagonal * 2.0
        }

        fun main() {
            val distance = TVMath.idealViewingDistance(85, true)
            println("Sit ${distance} inches away from TV!")

            val date = SimpleDate("July")
            println("${date.monthsUntilHalloween()} months until halloween")

            val circle = Circle(2.0)
            println("diameter: ${circle.diameter}")
        }
    }
}