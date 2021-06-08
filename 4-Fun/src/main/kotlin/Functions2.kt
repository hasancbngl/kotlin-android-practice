import java.security.cert.CertPathValidator

class Functions2 {
    companion object {

        fun validatePassword(password: String) = password.length >= 10

        fun mainM() {

            val email: String? = "test@test.com"
            val password: String? = "password"

            fun validateString(input: String?, inputType: String) =
                if (input == null || input.isBlank()) {
                    false
                } else if (inputType == "Password") {
                    input.length >= 10
                } else if (inputType == "Email") {
                    input.contains("@")
                } else {
                    println("Cannot verify this input type")
                    false
                }

            fun validateString(input: String?, validator: (String) -> Boolean) =
                if (input == null || input.isBlank()) false
                else validator(input)

            println(validateString("dssd", "Password"))

            val isValidEmail = validateString(email, "Email")
            println(isValidEmail)

            val isPasswprdValid = validateString(password, ::validatePassword)
            println("is pass valid: $isPasswprdValid")

            val passwordValidator = ::validatePassword
            println(passwordValidator)

            val validator: (String?) -> Boolean = { input ->
                input != null && validatePassword(input)
            }

            println(validator)
        }
    }
}