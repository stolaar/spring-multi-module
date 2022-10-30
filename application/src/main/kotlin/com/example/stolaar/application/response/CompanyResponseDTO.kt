package com.example.stolaar.application.response

import com.example.stolaar.domain.CompanyStatusEnum
import java.time.LocalDateTime
import java.util.*

data class CompanyResponseDTO(
    val id: UUID,
    val name: String,
    val status: CompanyStatusEnum,
    val createdAt: LocalDateTime = LocalDateTime.now()
)