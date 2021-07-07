/**
 * Enum class used for a  type where the value only
 * be one of a very limited potential values.
 * */

enum class DayOfTheWeek(val isWeekend: Boolean = false) {
    //if default value is provided no need to use Tuesday(value)
    //also when we use it, it'll override the default value
    Monday(false), Tuesday(false), Wednesday, Thursday,
    Friday, Saturday(true), Sunday(true);

    fun daysUntil(other: DayOfTheWeek): Int {
        return if (this.ordinal < other.ordinal) other.ordinal - this.ordinal else this.ordinal - other.ordinal
    }
}

fun main() {
    val today = DayOfTheWeek.Wednesday
    fun singAboutToday(today: DayOfTheWeek) {
        when (today) {
            DayOfTheWeek.Monday -> println("I don't care if $today's blue")
            DayOfTheWeek.Tuesday -> println("$today's gray")
            DayOfTheWeek.Wednesday -> println("And $today, too")
            DayOfTheWeek.Thursday -> println("$today, I don't care 'bout you")
            DayOfTheWeek.Friday -> println("It's $today, I'm in love")
            DayOfTheWeek.Saturday -> println("$today, Wait...")
            DayOfTheWeek.Sunday -> println("$today always comes too late")
        }
    }

    for(day in DayOfTheWeek.values()) {
        singAboutToday(day)
    }

    println("------------------------")
    for (day in DayOfTheWeek.values()) {
        //ordinal property is the index. enum class comes with custom properties
        println("Day ${day.ordinal}: ${day.name}, isweekend: ${day.isWeekend}")
    }

    val friday = DayOfTheWeek.Friday
    println(DayOfTheWeek.Tuesday.daysUntil(friday))
}