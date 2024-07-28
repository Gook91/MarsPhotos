package com.example.marsphotos.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

import com.example.marsphotos.entity.Photo

@JsonClass(generateAdapter = true)
data class PhotoDto(
    @Json(name = "id")
    override val id: Int,
    @Json(name = "sol")
    override val sol: Int,
    @Json(name = "camera")
    override val camera: CameraDto,
    @Json(name = "img_src")
    override val imgSrc: String,
    @Json(name = "earth_date")
    override val earthDate: String,
    @Json(name = "rover")
    override val rover: RoverDto
) : Photo