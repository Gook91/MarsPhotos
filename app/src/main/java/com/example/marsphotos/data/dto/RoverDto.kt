package com.example.marsphotos.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

import com.example.marsphotos.entity.Rover

@JsonClass(generateAdapter = true)
data class RoverDto(
    @Json(name = "id")
    override val id: Int,
    @Json(name = "name")
    override val name: String,
    @Json(name = "landing_date")
    override val landingDate: String,
    @Json(name = "launch_date")
    override val launchDate: String,
    @Json(name = "status")
    override val status: String
) : Rover