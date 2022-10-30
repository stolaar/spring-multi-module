package com.example.stolaar.domain.constants

import com.example.stolaar.common.domain.exceptions.NotFoundException

object Exceptions {
    val COMPANY_NOT_FOUND = NotFoundException("Company not found on database", "Company_NOT_FOUND")
}