package com.dev.freetoplay.domain.model

data class MinimumSystemRequirements(
    val graphics: String,
    val memory: String,
    val os: String,
    val processor: String,
    val storage: String
)