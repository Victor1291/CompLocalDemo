package com.shu.complocaldemo.kotlin.csv

data class Attr(
    val name: String, //уникальный индентификатор атрибута
    val tolerance: Tolerance // значимость атрибута для качества кончного продукта
)

enum class Tolerance {
    CRITICAL,
    IMPORTANT,
    REGULAR
}