class WhenExample {
    companion object {
        fun whenE(age: Int) {

            val ageMessage = when (age) {
                /*  25 -> println("quarter century!")
                  35 -> println("half of the way")
                  24 -> println("almost quarter century")
                  else -> println("no freaking idea!!") */

                in 0..12 -> "you're too young"
                in 13..19 -> "teenager"
                in 20..30 -> "twentiees"
                else -> "many stories :D"
            }
            println(ageMessage)


            val email: String? = "test@test.com"
            val password: String? = "timetoGo44!"

            when {
                email == null || email.isEmpty() -> println("You need to choose an email!")
                "@" !in email -> println("Your email is invalid :[")
                password == null || password.isEmpty() -> println("You need to choose a password!")
                password.length < 10 -> println("Password not strong enough :[")
                else -> println(
                    "Registration succeed!! Email length: ${email.length}, " +
                            "Password length: ${password.length}"
                )
            }
        }
    }
}