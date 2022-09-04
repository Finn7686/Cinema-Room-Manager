package cinema

import java.lang.IndexOutOfBoundsException

const val priceFrontSeats = 10
const val priceBackSeats = 8
const val smallCinemaLimit = 60

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val cols = readln().toInt()

    val cinemaSeats = MutableList(rows) { MutableList(cols) { "S" } }

    var purchasedTickets = 0
    var income = 0
    val totalIncome = getPricing(rows, cols)

    while (true) {
        println("""
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent())
        when (readln()) {
            "1" -> printSeats(cinemaSeats)
            "2" -> {
                income += getSeatPrice(cinemaSeats, rows, cols)
                purchasedTickets++
            }
            "3" -> {
                val percentage = purchasedTickets.toDouble() / (rows * cols) * 100
                println("""
                    Number of purchased tickets: $purchasedTickets
                    Percentage: ${ String.format("%.2f", percentage) }%
                    Current income: $$income
                    Total income: $$totalIncome
                """.trimIndent())
            }
            "0" -> break
        }
    }
}
fun getPricing(rows: Int, cols: Int): Int {
    val numberOfSeats = rows * cols
    if (numberOfSeats <= 60) return numberOfSeats * priceFrontSeats
    val frontSeats = rows / 2 * cols
    val backSeats = frontSeats + rows % 2 * cols
    return frontSeats * priceFrontSeats + backSeats * priceBackSeats
}


fun getSeatPrice(cinemaSeats: MutableList<MutableList<String>>, rows: Int, cols: Int): Int {
    var row: Int
    var col: Int

    while (true) {
        println("Enter a row number:")
        row = readln().toInt()
        println("Enter a seat number in that row:")
        col = readln().toInt()

        try {
            occupySeat(cinemaSeats, row, col)
            break
        } catch (e: IndexOutOfBoundsException) {
            println("Wrong input!")
        } catch (e: Exception) {
            println("That ticket has already been purchased!")
        }
    }

    val ticketPrice = if (rows * cols <= smallCinemaLimit || row <= rows / 2)
        priceFrontSeats
    else
        priceBackSeats

    println("Ticket Price: $$ticketPrice")
    return ticketPrice
}

fun occupySeat(
    cinemaSeats: MutableList<MutableList<String>>,
    row: Int,
    col: Int
) {
    if (cinemaSeats[row - 1][col - 1] == "B") throw Exception("Seat already occupied")
    cinemaSeats[row - 1][col - 1] = "B"
}

fun printSeats(cinemaSeats: MutableList<MutableList<String>>) {
    print("Cinema:\n  ")
    for (i in 1..cinemaSeats.first().size) print("$i ")
    println()
    for (i in cinemaSeats.indices) println("${ i + 1 } ${ cinemaSeats[i].joinToString(" ") }")
}