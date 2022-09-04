fun main() {
    val s1 = readln()
    val operator = readln()
    val s2 = readln()

    println(
        when (operator) {
            "equals" -> s1 == s2
            "plus" -> s1 + s2
            "endsWith" -> s1.endsWith(s2)
            else -> "Unknown operation"
        }
    )
}