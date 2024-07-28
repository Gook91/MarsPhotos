package com.example.marsphotos.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

import com.example.marsphotos.entity.Camera

@JsonClass(generateAdapter = true)
data class CameraDto(
    @Json(name = "id")
    override val id: Int,
    @Json(name = "name")
    override val name: String,
    @Json(name = "rover_id")
    override val roverId: Int,
    @Json(name = "full_name")
    override val fullName: String
) : Camera