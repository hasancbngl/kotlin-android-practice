import java.awt.geom.Area

/*
Challenge 1:
  - Create an interface `Shape` that defines a property `area` of type Double.
  - Implement `Shape` with classes representing Square, Triangle, and Circle.
  - Add a circle, a square, and a triangle to an array.
  - Convert the array of shapes to an array of areas using map.
 **HINTS**
 - The area of a square = one of its sides squared
 - The area of a triangle = 0.5 multiplied by its base multiplied by its height
 - The area of a circle = pi multiplied by its radius squared
*/

interface Shape {
    val area: Double
}

val Double.squared get() = this * this

class Square(var side: Double) : Shape {
    override val area: Double
        get() = side.squared
}

class Triangle : Shape {
    var a: Double
    var b: Double
    var c: Double

    constructor(a: Double, b: Double, c: Double) {
        this.a = a
        this.b = b
        this.c = c
    }

    override val area: Double
        get() = a + b + c
}

class Circle(val radius: Double) : Shape {
    override val area: Double
        get() = kotlin.math.PI * radius.squared
}

fun main() {
    val circle = Circle(radius = 8.5)
    val square = Square(5.2)
    val triangle = Triangle(7.0, 8.0, 12.0)

    val shapes: Array<Shape> = arrayOf(circle, square, triangle)
    shapes.forEach { println("Area of $it is ${it.area}") }

    val areas = shapes.map { it.area }
    println(areas)
}