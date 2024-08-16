package ru.netolohy

fun main() {

    fun commission(amount : Int, amountOfTransfer : Int, cardType : String) : Int {
        return when (cardType) {
            "Mastercard" -> {
                (if (amountOfTransfer > 75000) ((amount * 0.006) + 20).toInt()
                else 0)
            }
            "Visa" -> {
                (if (amount * 0.0075 < 35) 35
                else (amount * 0.0075).toInt())
            }
            else -> 0
        }
    }

    println("размер комиссии составит : ${commission(100000, 100000, "Mastercard")} рублей");
    println("размер комиссии составит : ${commission(100000, 100000, "Visa")} рублей");
    println("размер комиссии составит : ${commission(100000, 100000, "")} рублей");

}