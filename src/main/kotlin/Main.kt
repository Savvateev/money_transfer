package ru.netolohy
fun commission(amount : Int, amountOfTransfer : Int = 0, cardType : String = "МИР") : Int {
    return when (cardType) {
        "Mastercard" -> {
            when {
                (amountOfTransfer - amount) > 75000 -> ((amount * 0.006) + 20).toInt()
                amountOfTransfer > 75000 -> (((amountOfTransfer - 75000) * 0.006) + 20).toInt()
                else -> 0
            }
        }
        "Visa" -> {
            (if (amount * 0.0075 < 35) 35
            else (amount * 0.0075).toInt())
        }
        "МИР" -> 0
        // -100 ошибка типа карты
        else -> -100
    }
}
fun main() {
    val dayLimit = 150000
    val monthLimit = 600000
    var monthAmountOfTransfer = 0
    var dayAmountOfTransfer = 0

    fun transfer(amount : Int, cardType: String = "МИР") : Boolean {
        if ((amount > dayLimit) || ((monthAmountOfTransfer + amount) > monthLimit)
            || ((dayAmountOfTransfer + amount) > dayLimit)) {
            println("Перевод не совершон, превышен лимит перевода")
            return false
        }
        else {
            monthAmountOfTransfer += amount
            dayAmountOfTransfer += amount
            println("Перевод $cardType $amount руб.")
            println("размер комиссии составит : " +
                    "${commission(amount, monthAmountOfTransfer,cardType)} рублей")
            println("Ваш лимит переводов на сегодня : ${dayLimit-amount} рублей")
            println("Ваш лимит переводов в этом месяце : ${monthLimit-monthAmountOfTransfer} рублей")
            return true
        }
    }

    transfer(150000, "Mastercard")
    transfer(5000)
    dayAmountOfTransfer = 0
    transfer(100000, "Visa")
}