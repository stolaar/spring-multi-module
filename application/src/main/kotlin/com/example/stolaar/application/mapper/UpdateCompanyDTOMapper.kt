package com.example.stolaar.application.mapper

import com.example.stolaar.application.request.UpdateCompanyRequestDTO
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.domain.model.RequestResponseDTOMapper
import com.example.stolaar.domain.model.Company
import java.util.*

object UpdateCompanyDTOMapper : RequestResponseDTOMapper<UpdateCompanyRequestDTO, CompanyResponseDTO, Company> {

    override fun mapFromDTO(obj: UpdateCompanyRequestDTO): Company {
        return with(obj) {
            Company(
                id = UUID.fromString(id),
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