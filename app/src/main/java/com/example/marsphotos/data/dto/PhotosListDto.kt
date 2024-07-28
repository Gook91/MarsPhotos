package com.example.marsphotos.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotosListDto(
    @Json(name = "photos")
    val photos: List<PhotoDto>
)