interface Vehicle {
    fun accelerate()
    fun stop()
}

class Unicycle : Vehicle {
    var peddling = false

    override fun accelerate() {
        peddling = true
        println("weeee")
    }

    override fun stop() {
        peddling = false
        println("Noooo")
    }
}

enum class Direction {
    LEFT, RIGHT
}

//interfaces can implement other interfaces same as classes implements other classes
interface TurningVehicle : Vehicle {
    fun turn(direction: Direction = Direction.RIGHT)
    fun description(): String
}

interface Spacey {
    val tribblesCount: Int
}

interface SpaceVehicle : Vehicle, Spacey {
    val name: String
        get() = "Space Vehicle"

    override fun accelerate() {
        println("Proceed to HyperSpace!")
    }

    override fun stop() {
        println("Whoaa, Slow down!")
    }
}

class LightFreighter(override val tribblesCount: Int = 0) : SpaceVehicle {

    var hyperDriveBusted: Boolean = false
    override fun stop() {
        //super.execute the fun means calls the default implementation(default behavior)
        // super.stop()
        hyperDriveBusted = true
        println("HyperDrive Failure...Again")
    }
}

class Starship : SpaceVehicle {
    override val tribblesCount: Int
        get() = Int.MAX_VALUE

    override val name: String
        get() = "Starship!"

    override fun accelerate() {
        println("Warp Factor, 9 Please!")
    }

    override fun stop() {
        super.stop()
        println("that kind of hurt...")
    }
}

fun main() {
    val unicycle = Unicycle()
    unicycle.accelerate()
    unicycle.stop()

    val lightFreighter = LightFreighter()
    lightFreighter.accelerate()
    lightFreighter.stop()

    println("name: ${lightFreighter.name}!!!,  TribblesCount:  ${lightFreighter.tribblesCount}")

    val starship = Starship()
    starship.accelerate()
    starship.stop()
    println("name: ${starship.name} ,TribblesCount:  ${starship.tribblesCount}")
}