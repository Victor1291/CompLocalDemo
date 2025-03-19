package com.shu.complocaldemo.solid.dip

/*
5. Принцип инверсии зависимостей (DIP)
Модули высокого уровня не должны зависеть от модулей низкого уровня.
 Оба должны зависеть от абстракций.

Этот принцип уменьшает связь между модулями высокого и
низкого уровня за счёт введения абстракций.

Breaking DIP:
 */

class EmailService2 {
    fun sendEmail(message: String) {
        println("Sending Email: $message")
    }
}

class NotificationSender2 {
    private val emailService = EmailService2()

    fun notifyUser(message: String) {
        emailService.sendEmail(message)
    }
}

/*
Здесь NotificationSender2 тесно связан с EmailService2,
 что затрудняет переход на другой сервис уведомлений.

 Fixing DIP:
 */

interface NotificationService {
    fun sendNotification(message: String)
}

class EmailService : NotificationService {
    override fun sendNotification(message: String) {
        println("Sending Email: $message")
    }
}

class SMSService : NotificationService {
    override fun sendNotification(message: String) {
        println("Sending SMS: $message")
    }
}

class NotificationSender(private val service: NotificationService) {
    fun notifyUser(message: String) {
        service.sendNotification(message)
    }
}

fun main() {
    val emailSender = NotificationSender(EmailService())
    emailSender.notifyUser("Hello via Email")

    val smsSender = NotificationSender(SMSService())
    smsSender.notifyUser("Hello via SMS")
}

/*
Здесь NotificationSender зависит от абстракции NotificationService,
что делает его гибким для работы с любым типом уведомлений.
 */

/*
Принципы SOLID лежат в основе создания надёжного и масштабируемого программного обеспечения.
 Kotlin с его выразительным синтаксисом и современными функциями позволяет
 разработчикам элегантно реализовывать эти принципы. Следуя этим принципам,
 вы можете создавать код, который проще поддерживать, расширять и
  адаптировать к меняющимся требованиям.
 */