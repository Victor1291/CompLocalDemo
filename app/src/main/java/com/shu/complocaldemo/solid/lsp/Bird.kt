package com.shu.complocaldemo.solid.lsp


/*
3. Принцип замещения Лискова (LSP)
Объекты суперкласса должны заменяться объектами подкласса без ущерба
для корректности программы.

Этот принцип гарантирует, что производные классы соответствуют ожиданиям,
 установленным их базовым классом.

Нарушающий LSP:
 */

open class Bird {
    open fun fly() {
        println("Flying")
    }
}

class Sparrow : Bird()

class Penguin : Bird() {
    override fun fly() {
        throw UnsupportedOperationException("Penguins can't fly")
    }
}

fun main() {
    val birds: List<Bird> = listOf(Sparrow(), Penguin())

    for (bird in birds) {
        bird.fly() // This will fail for Penguin
    }
}

/*
В этом примере Penguin нарушает LSP, потому что
 не может выполнить контракт Bird.
  Лучше всего провести рефакторинг дизайна:
 */


interface Flyable {
    fun fly()
}

class Sparrow2 : Flyable {
    override fun fly() {
        println("Flying")
    }
}

class Penguin2 {
    fun swim() {
        println("Swimming")
    }
}

/*
Теперь модели поведения разделены, и LSP поддерживается.
 */