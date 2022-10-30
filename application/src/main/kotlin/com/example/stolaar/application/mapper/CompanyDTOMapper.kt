package com.example.stolaar.application.mapper

import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.domain.model.DTOMapper
import com.example.stolaar.domain.model.Company

object CompanyDTOMapper : DTOMapper<CompanyResponseDTO, Company>  {

    override fun mapFromDTO(obj: CompanyResponseDTO): Company {
        return with(obj) {
            Company(
                id = id,
                name = name,
                status = status,
                createdAt = createdAt
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