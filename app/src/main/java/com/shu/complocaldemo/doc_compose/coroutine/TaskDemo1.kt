package com.shu.complocaldemo.doc_compose.coroutine

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Task1() {
    val coroutineScope = rememberCoroutineScope()
    Button(onClick = {
        coroutineScope.launch {
            performSlowTask()
        }
    }) {
        Text(text = "Click Me")
    }
    val channel = Channel<Int>()
    LaunchedEffect(true) {
        coroutineScope.launch(Dispatchers.Main) { performTask1(channel) }
        coroutineScope.launch(Dispatchers.Main) { performTask2(channel) }
    }

}

suspend fun performTask1(channel :Channel<Int>) {
    (1..6).forEach {
        channel.send(it)
    }
}


suspend fun performTask2(channel : Channel<Int>) {
    repeat(6) {
        println("Received: ${channel.receive()}")
    }
}


suspend fun performSlowTask() {
    println("performSlowTask before")
    delay(5000) // simulates long-running task
    println("performSlowTask after")
}

/*@Composable
fun Greeting(name: String) {
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch() {
        performSlowTask()
    }
}*/

@Composable
fun Greeting(name: String) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        coroutineScope.launch() {
            performSlowTask()
        }
    }
}

/*

В реализованном виде функция выводит диагностические сообщения до и после выполнения 5-секундной
задержки, имитируя длительную задачу. Пока действует 5-секундная задержка, пользовательский интерфейс
 будет оставаться отзывчивым, поскольку основной поток не блокируется. Чтобы понять, почему это
 помогает, рассмотрим, что происходит за кулисами.

Щелчок по кнопке запускает Выполняет текущую задачу() приостановить функцию как сопрограмму. Затем
эта функция вызывает Kotlinзадержка() функция, передающая значение времени. На самом деле, встроенная
 функция Kotlin задержка() функция сама по себе реализована как приостанавливаемая функция, поэтому
  она также запускается как сопрограмма средой выполнения Kotlin. Выполнение кода достигло так
   называемой приостанавливаемой точки, которая приведёт к Выполняет текущую задачу() корутина
   приостанавливается во время выполнения корутины задержки. Это освобождает поток, в котором
   Выполняет текущую задачу() выполнялся и возвращает управление в основной поток, чтобы не влиять
    на пользовательский интерфейс.

Как только задержка() когда функция завершит работу, приостановленная сопрограмма будет возобновлен
 и восстановлена в потоке из пула, где она сможет отобразить сообщение журнала и вернуться.

При работе с сопрограммами в Android Studio точки приостановки в редакторе кода помечаются,
 как показано на рисунке ниже:
 */