package com.shu.complocaldemo.solid.srp

/*
1. Принцип единой ответственности (SRP)
У класса должна быть одна, и только одна, причина для изменения.

Этот принцип гарантирует, что у класса будет только одна задача, что упрощает его поддержку и снижает вероятность ошибок.

Нарушение SRP:
 */

class ReportManager {
    fun generateReport(data: String): String {
        // Logic to generate report
        return "Report: $data"
    }

    fun saveReport(report: String) {
        // Logic to save report
        println("Report saved: $report")
    }
}

/*
В этом примере класс ReportManager нарушает принцип единой ответственности,
поскольку у него две задачи: создание и сохранение отчётов.
Любое изменение логики создания или сохранения отчётов потребует изменения
 того же класса.

Исправление SRP:
 */

class ReportGenerator {
    fun generateReport(data: String): String {
        // Logic to generate report
        return "Report: $data"
    }
}

class ReportSaver {
    fun saveReport(report: String) {
        // Logic to save report
        println("Report saved: $report")
    }
}

fun main() {
    val generator = ReportGenerator()
    val saver = ReportSaver()

    val report = generator.generateReport("Sales Data")
    saver.saveReport(report)
}

/*
Разделяя обязанности, мы делаем каждый класс более целенаправленным,
 и его становится проще тестировать самостоятельно.
 */