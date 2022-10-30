package com.example.stolaar.application.usecase

import com.example.stolaar.application.mapper.CreateCompanyDTOMapper
import com.example.stolaar.application.request.CreateCompanyRequestDTO
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.application.RequestResponseUseCase
import com.example.stolaar.common.domain.annotations.UseCase
import com.example.stolaar.domain.service.CompanyService

@UseCase
class CreateCompanyUseCase(
    private val CompanyService: CompanyService
) : RequestResponseUseCase<CreateCompanyRequestDTO, CompanyResponseDTO> {

    override fun execute(request: CreateCompanyRequestDTO): CompanyResponseDTO {
        return CreateCompanyDTOMapper.mapToDTO(
            CompanyService.save(
                CreateCompanyDTOMapper.mapFromDTO(request)
            )
        )
    }

}