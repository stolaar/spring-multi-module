package com.example.stolaar.application.request

import com.example.stolaar.domain.CompanyStatusEnum

data class UpdateCompanyRequestDTO(
    val id: String,
    val name: String,
    val status: CompanyStatusEnum,
)