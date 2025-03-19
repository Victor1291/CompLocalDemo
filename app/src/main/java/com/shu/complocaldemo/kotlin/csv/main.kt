package com.shu.complocaldemo.kotlin.csv

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val dates = listOf<LocalDateTime>(
        LocalDateTime.parse("2020-07-27T15:15:00"),
        LocalDateTime.parse("2020-07-27T15:25:00"),
        LocalDateTime.parse("2020-07-27T15:35:00"),
        LocalDateTime.parse("2020-07-27T15:45:00")
    )

    val seriesExample = listOf(
        TimeSeries(
            points = listOf(
                Point("HC11",dates[3],15.1),
                Point("HC12",dates[2],15.05),
                Point("HC13",dates[1],15.11),
                Point("HC14",dates[0],15.08),
            ),
            attr = Attr("AngelOfAttack", Tolerance.CRITICAL)
        ),
        TimeSeries(
            points = listOf(
                Point("HC11",dates[3],0.68),
                Point("HC12",dates[2],0.7),
                Point("HC13",dates[1],0.69),
                Point("HC14",dates[0],0.71),
            ),
            attr = Attr("ChordLength", Tolerance.IMPORTANT)
        ),
        TimeSeries(
            points = listOf(
                Point("HC11",dates[3],0x2196F3.toDouble()),
                Point("HC14",dates[0],0x795548.toDouble()),
            ),
            attr = Attr("PaintColor", Tolerance.REGULAR)
        ),
    )
    val csv = createCsv(seriesExample)
    println(csv)

}

fun createCsv(timeSeries: List<TimeSeries>) : String {
    val distinctAttrs = timeSeries
        .distinctBy { it.attr } // чтобы получить список с разными значениями attr
        .map { it.attr }  // берём только attr
        .sortedBy { it.name } //сортировка по алфавиту

    // Преобразуем список в строку . Можно указать префикс или постфикс
    val csvHeader = "date,serial," +
            distinctAttrs.joinToString(",") { it.name } + "\n"

    //Для начала объединяем и уплощаем данные
    //чтобы можно было работать со списком PointWithAttr
    //очень похоже на соединение двух таблиц в SQL
    //Если бы вместо flatMap мы использовали функцию map, то создали List<List<PointAndAttr>>
    val pointWithAttrs = timeSeries.flatMap { ts ->
        ts.points.map { point -> PointWithAttr(point,ts.attr) }
    }

    val pointsWithAttrs2 = timeSeries.filter {
        it.attr.tolerance == Tolerance.CRITICAL || it.attr.tolerance == Tolerance.IMPORTANT
    }.map { series ->
        series.points.map { point ->
            PointWithAttr(point, series.attr)
        }
    }.flatten()
    /*
    Мы сгруппируем список pointWithAttrs по дате, чтобы создать Map<LocalDate>, List<PointWithAttr>.
    Этот фссоциативный массив будет содержать список pointWithAttrs для каждой даты.
     */

    val rows = pointWithAttrs.groupBy { it.point.date } // выполняем группировку по дате
        .toSortedMap() //Сортируем ассоциативный массив (по дате)
        .map { (date, ptsWithAttrs1) ->
            ptsWithAttrs1
                .groupBy { it.point.serial } //группировка по серийному номеру
                .map { (serial, ptsWithAttrs2) ->
                    listOf (  //Создаём список значений для каждой строки
                        date.format(DateTimeFormatter.ISO_LOCAL_DATE),
                        serial
                    ) + distinctAttrs.map { attr ->
                        val value = ptsWithAttrs2.firstOrNull(){ it.attr == attr }
                        value?.point?.value?.toString() ?: ""
                    }
                }.joinToString("") {  // Форматируем каждую строку и собираем все строки с помощью функции joinToString
                    it.joinToString(",", postfix = "\n")
                }
        }.joinToString("")

    return csvHeader + rows
}
