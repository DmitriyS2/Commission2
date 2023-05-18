fun main(args: Array<String>) {
    val typeCard = "Maestro"
    val lastTransfer = 100000
    val transfer = 1000

    println("Комиссия составит: " + getCommission(typeCard, lastTransfer, transfer) + " руб.")
}

fun getCommission(typeCard: String = "VK Pay", lastTransfer: Int = 0, transfer: Int): Int {
    var commission = 0
    when (typeCard) {
        "Mastercard", "Maestro" -> commission =
            if (lastTransfer < 75001) commission else (transfer * 0.6 / 100 + 20).toInt()

        "Visa", "Мир" -> commission = if ((transfer * 0.75 / 100) > 35) (transfer * 0.75 / 100).toInt() else 35
    }
    return commission
}