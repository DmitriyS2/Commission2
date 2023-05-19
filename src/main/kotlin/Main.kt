fun main(args: Array<String>) {
    val typeCard = "Maestro"
    val lastTransfer = 100000
    val transfer = 1000

    if (isTransfer(typeCard, lastTransfer, transfer)) {
        println("Комиссия составит: " + getCommission(typeCard, lastTransfer, transfer) + " руб.")
    } else println("Вы превысили лимит. Перевод невозможен")
}

fun isTransfer(typeCard: String = "VK Pay", lastTransfer: Int = 0, transfer: Int): Boolean {
    var mayBeTransfer = false
    when (typeCard) {
        "VK Pay" -> mayBeTransfer = if ((lastTransfer + transfer) <= 40000 && transfer <= 15000) true else false
        "Мир", "Visa", "Mastercard", "Maestro" -> mayBeTransfer =
            if ((lastTransfer + transfer) <= 600000 && transfer <= 150000) true else false
    }
    return mayBeTransfer
}

fun getCommission(typeCard: String = "VK Pay", lastTransfer: Int = 0, transfer: Int): Int {
    var commission = 0
    when (typeCard) {
        "Mastercard", "Maestro" -> commission =
            if ((lastTransfer + transfer) < 75000) commission else (transfer * 0.6 / 100 + 20).toInt()

        "Visa", "Мир" -> commission = if ((transfer * 0.75 / 100) > 35) (transfer * 0.75 / 100).toInt() else 35
    }
    return commission
}