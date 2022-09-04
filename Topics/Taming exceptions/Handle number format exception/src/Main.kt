fun parseCardNumber(cardNumber: String): Long {
    val regex = Regex("[0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9]")
    if (!regex.matches(cardNumber)) {
        throw Exception("Card number is incorrect")
    }
    return cardNumber.replace(" ", "").toLong()
}