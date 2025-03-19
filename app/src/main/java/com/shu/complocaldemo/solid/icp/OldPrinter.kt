package com.shu.complocaldemo.solid.icp


/*
4. Принцип разделения интерфейса (ISP)
Клиенты не должны быть вынуждены зависеть от методов,
которые они не используют.

Этот принцип способствует созданию конкретных интерфейсов,
 а не раздутых.

Взлом интернет-провайдера:
 */

interface Machine {
    fun print()
    fun scan()
    fun fax()
}

class OldPrinter : Machine {
    override fun print() {
        println("Printing")
    }

    override fun scan() {
        throw UnsupportedOperationException("Scan not supported")
    }

    override fun fax() {
        throw UnsupportedOperationException("Fax not supported")
    }
}

/*
Эта реализация вынуждает OldPrinter реализовывать методы,
 которые он не поддерживает, что нарушает ISP.

Исправление интернет-провайдера:
 */

interface Printer {
    fun print()
}

interface Scanner {
    fun scan()
}

class SimplePrinter : Printer {
    override fun print() {
        println("Printing")
    }
}

/*
Разделив функции на отдельные интерфейсы,
 мы позволяем устройствам реализовывать только то, что им необходимо.
 */