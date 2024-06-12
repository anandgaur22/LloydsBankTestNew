package com.anand.data.mapper


import com.anand.data.model.FixtureDto
import com.anand.domain.model.Fixture

fun FixtureDto.toDomain(): Fixture {
    return Fixture(
        id = id,
        name = name,
        resultInfo = result_info,
        startingAt = starting_at
    )
}
