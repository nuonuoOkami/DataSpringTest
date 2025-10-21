package com.dataspring.test

import java.time.Clock
import java.time.LocalTime

/**
 * 测试类
 * @param clock  传入测试时间
 */
class MyGreeter(private val clock: Clock = Clock.systemDefaultZone()) {
    fun greeting(): String {
        val hour = LocalTime.now(clock).hour
        return when (hour) {
            in 6..11 -> TimeTags.MORNING
            in 12..17 -> TimeTags.AFTERNOON
            else -> TimeTags.EVENING
        }
    }
}