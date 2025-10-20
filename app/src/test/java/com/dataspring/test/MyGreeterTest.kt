package com.dataspring.test


import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

/**
 * 测试类
 */
class MyGreeterTest {
    private lateinit var greeter: MyGreeter
    private val zoneId = ZoneId.of("Asia/Shanghai")
    //测试日期
    private val fixedDate = LocalDate.of(2025, 1, 1)

    @Before
    fun setUp() {
        greeter = MyGreeter()
    }

    @Test
    fun testInit() {
        assertTrue(greeter is MyGreeter)
    }

    /**
     * 测试是返回为is null or ""
     */
    @Test
    fun testGreetingNonEmpty() {
        assertTrue(greeter.greeting().isNotEmpty())
    }


    /**
     * 测试边界 23:59
     */
    @Test
    fun testGreetingAt2359ReturnsGoodEvening() {
        val fixedClock = createFixedClock(23, 59)
        greeter = MyGreeter(fixedClock)
        assertEquals("Good evening", greeter.greeting())
    }
    /**
     * 测试边界
     *17:59
     */
    @Test
    fun testGreetingAt1800ReturnsGoodEvening() {
        val fixedClock = createFixedClock(17, 59)
        greeter = MyGreeter(fixedClock)
        assertEquals("Good evening", greeter.greeting())
    }
    /**
     * 构建测试Clock
     */
    private fun createFixedClock(
        hour: Int,
        minute: Int,
        second: Int = 59,
        nanoOfSecond: Int = 999000000
    ): Clock {
        val localDateTime = fixedDate.atTime(hour, minute, second, nanoOfSecond)
        val instant = localDateTime.toInstant(zoneId.rules.getOffset(Instant.now()))
        return Clock.fixed(instant, zoneId)
    }
}