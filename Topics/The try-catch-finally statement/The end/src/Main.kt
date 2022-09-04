fun solution() {
    try {
        val a = readln().toInt()
        val b = readln().toInt()
        println(a / b)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}