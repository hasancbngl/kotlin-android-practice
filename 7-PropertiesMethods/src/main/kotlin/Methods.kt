class Methods {

    val months = arrayOf(
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    )

    class SimpleDate(var month: String)

    fun monthsUntilJingleBells(from: SimpleDate): Int {
        return months.indexOf("December") - months.indexOf(from.month)
    }

    companion object {
        fun main() {

        }
    }
}