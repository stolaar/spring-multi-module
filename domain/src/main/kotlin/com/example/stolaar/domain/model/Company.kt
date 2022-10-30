package com.example.stolaar.domain.model

import com.example.stolaar.domain.CompanyStatusEnum
import java.time.LocalDateTime
import java.util.UUID

data class Company(
    var id: UUID? = null,
    val name: String,
    val status: CompanyStatusEnum,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
