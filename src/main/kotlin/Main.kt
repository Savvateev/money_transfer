package ru.netolohy

fun main() {
    // сумма перевода в рублях
    val amount = 10_000
    // сцмма перевода в копейках
    val naturalAmount = amount * 100
    // размер комиссии 0,75%
    val commissionSize = 0.0075
    // размер минимальной комиссии 35р в копейках
    val minCommission = 3500
    // вычисляем размер комиссии в рублях
    val commission =
        if ((naturalAmount * commissionSize) > minCommission) {
            (naturalAmount * commissionSize)/100
        } else {
            minCommission/100
        }
    println("размер комиссии составит : $commission рублей");
}