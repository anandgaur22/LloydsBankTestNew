package com.anand.data

import com.anand.data.model.FixtureDto
import org.junit.Assert.assertEquals
import org.junit.Test

class FixtureDtoTest {

    @Test
    fun `test FixtureDto properties`() {
        // Create an instance of FixtureDto
        val fixture = FixtureDto(
            id = 1,
            name = "Test Fixture",
            result_info = "Win",
            starting_at = "2024-06-11T12:00:00Z"
        )

        // Verify the properties
        assertEquals(1, fixture.id)
        assertEquals("Test Fixture", fixture.name)
        assertEquals("Win", fixture.result_info)
        assertEquals("2024-06-11T12:00:00Z", fixture.starting_at)
    }

    @Test
    fun `test FixtureDto equality`() {
        // Create two instances of FixtureDto with the same properties
        val fixture1 = FixtureDto(
            id = 1,
            name = "Test Fixture",
            result_info = "Win",
            starting_at = "2024-06-11T12:00:00Z"
        )

        val fixture2 = FixtureDto(
            id = 1,
            name = "Test Fixture",
            result_info = "Win",
            starting_at = "2024-06-11T12:00:00Z"
        )

        // Verify that they are equal
        assertEquals(fixture1, fixture2)
    }

    @Test
    fun `test FixtureDto copy`() {
        // Create an instance of FixtureDto
        val fixture = FixtureDto(
            id = 1,
            name = "Test Fixture",
            result_info = "Win",
            starting_at = "2024-06-11T12:00:00Z"
        )

        // Create a copy with a modified property
        val modifiedFixture = fixture.copy(name = "Modified Fixture")

        // Verify the properties
        assertEquals(1, modifiedFixture.id)
        assertEquals("Modified Fixture", modifiedFixture.name)
        assertEquals("Win", modifiedFixture.result_info)
        assertEquals("2024-06-11T12:00:00Z", modifiedFixture.starting_at)
    }
}
