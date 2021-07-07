sealed class AcceptedCurrency {
    abstract val valueInDollars: Float
    var amount = 0.0f
    class Dollar : AcceptedCurrency() {
        override val valueInDollars = 1.0f
    }

    class Euro : AcceptedCurrency() {
        override val valueInDollars = 1.25f
    }

    class Crypto : AcceptedCurrency() {
        override val valueInDollars = 3.485745f
    }

    val name: String
        get() =
            when (this) {
                is Euro -> "Euro"
                is Dollar -> "Dollar"
                is Crypto -> "FCoin"
            }

    fun totalValueInDollars() : Float {
        return amount * valueInDollars
    }
}

fun main() {
    val currency = AcceptedCurrency.Crypto()
    println("you got some ${currency.name}!!")
    currency.amount = .457f
    println(currency.valueInDollars)

    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")

    val euro = AcceptedCurrency.Euro()
    println("you got some ${euro.name}!!")
    euro.amount = 4545.457f

    println("${euro.amount} of ${euro.name} is ${euro.totalValueInDollars()} in Dollars")
}