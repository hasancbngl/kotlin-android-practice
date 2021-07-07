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
        override val valueInDollars = 3415.445f
    }

    val name: String
        get() =
            when (this) {
                is Euro -> "Euro"
                is Dollar -> "Dollar"
                is Crypto -> "FCoin"
            }

    fun totalValueInDollars(): Float {
        return amount * valueInDollars
    }

    companion object {
        fun checkSuffecientFunds(costInDollars: Float, currentFunds: List<AcceptedCurrency>): Boolean {
            val totalFundsInDollars = currentFunds.fold(0.0f) { accumulator, currency ->
                accumulator + currency.valueInDollars
            }
            return totalFundsInDollars >= costInDollars
        }
    }
}

fun main() {
    val currency2 = AcceptedCurrency.Crypto()
    currency2.amount = .27541f
    val dollars = AcceptedCurrency.Dollar()
    dollars.amount = 2000f

    val sufficientBalance =
        AcceptedCurrency.checkSuffecientFunds(1000f, listOf(currency2, dollars))
    println("You ${if (sufficientBalance) "have" else "don't "} enough money to buy that item! ")

    println("------------------------------")
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