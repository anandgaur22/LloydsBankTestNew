package com.anand.domain.model

import org.junit.Assert.*
import org.junit.Test

class FixtureTest {

    @Test
    fun `test fixture creation`() {
        val fixture = Fixture(
            id = 1,
            name = "Fixture 1",
            resultInfo = "Result 1",
            startingAt = "2024-06-11"
        )

        assertEquals(1, fixture.id)
        assertEquals("Fixture 1", fixture.name)
        assertEquals("Result 1", fixture.resultInfo)
        assertEquals("2024-06-11", fixture.startingAt)
    }

    @Test
    fun `test fixtures equality`() {
        val fixture1 = Fixture(
            id = 1,
            name = "Fixture 1",
            resultInfo = "Result 1",
            startingAt = "2024-06-11"
        )

        val fixture2 = Fixture(
            id = 1,
            name = "Fixture 1",
            resultInfo = "Result 1",
            startingAt = "2024-06-11"
        )

        assertEquals(fixture1, fixture2)
    }

    @Test
    fun `test fixtures inequality`() {
        val fixture1 = Fixture(
            id = 1,
            name = "Fixture 1",
            resultInfo = "Result 1",
            startingAt = "2024-06-11"
        )

        val fixture2 = Fixture(
            id = 2,
            name = "Fixture 2",
            resultInfo = "Result 2",
            startingAt = "2024-06-12"
        )

        assertNotEquals(fixture1, fixture2)
    }

    @Test
    fun `test hashcode consistency`() {
        val fixture = Fixture(
            id = 1,
            name = "Fixture 1",
            resultInfo = "Result 1",
            startingAt = "2024-06-11"
        )

        val initialHashCode = fixture.hashCode()
        val secondHashCode = fixture.hashCode()

        assertEquals(initialHashCode, secondHashCode)
    }

    @Test
    fun `test toString output`() {
        val fixture = Fixture(
            id = 1,
            name = "Fixture 1",
            resultInfo = "Result 1",
            startingAt = "2024-06-11"
        )

        val expectedToString = "Fixture(id=1, name=Fixture 1, resultInfo=Result 1, startingAt=2024-06-11)"
        assertEquals(expectedToString, fixture.toString())
    }
}
