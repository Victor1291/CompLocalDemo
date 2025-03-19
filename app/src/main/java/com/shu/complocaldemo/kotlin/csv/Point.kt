package com.shu.complocaldemo.kotlin.csv

import java.time.LocalDateTime



data class Point(
    val serial: String,
    val date: LocalDateTime,
    val value: Double
)

/**
 *Связывет список измерений с атрибутами.
 */
data class TimeSeries(
    val points: List<Point>,
    val attr: Attr
)