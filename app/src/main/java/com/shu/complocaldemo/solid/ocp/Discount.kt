package com.shu.complocaldemo.solid.ocp

/*
2. Принцип открытости / закрытости (OCP)
Программные объекты должны быть открыты для расширения,
 но закрыты для модификации.

Вы можете добавить новую функциональность, расширив классы
 без изменения существующего кода.

Нарушение OCP:
 */

class Discount {

    fun calculate(price: Double, type: String): Double {
        return when (type) {
            "none" -> price
            "percentage" -> price * 0.9
            else -> throw IllegalArgumentException("Unknown discount type")
        }
    }
}

/*
Здесь для добавления нового типа скидки требуется изменить метод calculate,
 что нарушает OCP.

Исправление OCP:
 */

interface DiscountStrategy {
    fun calculate(price: Double): Double
}

class NoDiscount : DiscountStrategy {
    override fun calculate(price: Double): Double = price
}

class PercentageDiscount(private val percentage: Double) : DiscountStrategy {
    override fun calculate(price: Double): Double = price * (1 - percentage / 100)
}

class DiscountCalculator(private val strategy: DiscountStrategy) {
    fun calculate(price: Double): Double = strategy.calculate(price)
}

fun main() {
    val noDiscount = DiscountCalculator(NoDiscount())
    println("Price after no discount: ${noDiscount.calculate(100.0)}")

    val percentageDiscount = DiscountCalculator(PercentageDiscount(10.0))
    println("Price after 10% discount: ${percentageDiscount.calculate(100.0)}")
}

/*
Используя интерфейсы и композицию, мы создаём дизайн, который открыт для расширения
 (новые стратегии скидок) и закрыт для изменений (без внесения изменений в существующие классы).
 */