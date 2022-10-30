package com.example.stolaar.application.usecase

import com.example.stolaar.application.mapper.UpdateCompanyDTOMapper
import com.example.stolaar.application.request.UpdateCompanyRequestDTO
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.application.RequestResponseUseCase
import com.example.stolaar.common.domain.annotations.UseCase
import com.example.stolaar.domain.service.CompanyService

@UseCase
class UpdateCompanyUseCase(
    private val CompanyService: CompanyService
) : RequestResponseUseCase<UpdateCompanyRequestDTO, CompanyResponseDTO> {

    override fun execute(request: UpdateCompanyRequestDTO): CompanyResponseDTO {
        return UpdateCompanyDTOMapper.mapToDTO(
            CompanyService.update(
                UpdateCompanyDTOMapper.mapFromDTO(request)
            )
        )
    }

}