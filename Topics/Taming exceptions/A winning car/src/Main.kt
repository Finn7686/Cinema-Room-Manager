fun findCar(): String {
    val maxSpeed = readln().toInt()
    val accTime = readln().toInt()

    // write your code here
    if (maxSpeed < 120 || accTime > 4 || accTime < 1) {
        throw Exception("The race can't be won with this car")
    }
    return "I will definitely win!"
}