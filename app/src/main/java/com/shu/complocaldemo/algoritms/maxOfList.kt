package com.shu.complocaldemo.algoritms

fun main() {

    val ages = listOf(10,6,15,93,42,7,32)



    val maxAge = ages.maxOf { it }
    val maxAgeSorted = ages.sorted().last()

    println(maxAge)
    println(maxAgeSorted)

    val ageMom = 45
    val agePap = 47

    val maxAgeS = Math.max(ageMom,agePap)

    val ageGrandMam = 83

    val maxThree = Math.max(maxAgeS,ageGrandMam)

    println("MaxThree $maxThree ")

    //Выйгрыш в 100 раз
    var maxAgeNew = 0
    for (i in ages) {
        maxAgeNew = Math.max(maxAgeNew, i)
    }
println("Максимальный элемент массива $maxAgeNew ")
}