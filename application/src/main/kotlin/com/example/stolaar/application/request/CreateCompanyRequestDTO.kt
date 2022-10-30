package com.example.stolaar.application.request

import com.example.stolaar.domain.CompanyStatusEnum

data class CreateCompanyRequestDTO(
    val name: String,
    val status: CompanyStatusEnum,
)