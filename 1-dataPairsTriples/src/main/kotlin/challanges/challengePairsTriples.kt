package challanges

/*
* Create a Pair which holds information about a Bank Account.
* A Bank Account needs to have a Credit Card connected to it, and a balance. (Hint: You can nest a Triple in a Pair)
* A Credit Card should have a Card number, security code, and the type of the card (e.g. "Visa", "MasterCard").
*
* Print out the data for the Account, while hiding the security code.
* */

class challengePairsTriples {
    companion object Challenge {
        val creditCard = Triple(244242244224242442, 244, "Visa")
        val bankAccount = Pair(creditCard, 250)

        fun printData() {
            val (card, balance) = bankAccount
            var (cardNumber, _, type) = card

            val accountInfo = "Account information: \n Card Number : $cardNumber \n type: $type " +
                    "\n balance: $balance"
            println(accountInfo)
        }
    }
}