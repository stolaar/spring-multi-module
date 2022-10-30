package com.example.stolaar.application.mapper

import com.example.stolaar.application.request.CreateCompanyRequestDTO
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.domain.model.RequestResponseDTOMapper
import com.example.stolaar.domain.model.Company

object CreateCompanyDTOMapper : RequestResponseDTOMapper<CreateCompanyRequestDTO, CompanyResponseDTO, Company> {

    override fun mapFromDTO(obj: CreateCompanyRequestDTO): Company {
        return with(obj) {
            Company(
                name = name,
                status = status
            )
        }
    }

    override fun mapToDTO(obj: Company): CompanyResponseDTO {
        return with(obj) {
            CompanyResponseDTO(
                id = id!!,
                name = name,
                status = status,
                createdAt = createdAt
            )
        }
    }

}