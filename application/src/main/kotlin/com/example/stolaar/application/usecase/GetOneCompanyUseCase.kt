package com.example.stolaar.application.usecase

import com.example.stolaar.application.mapper.CompanyDTOMapper
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.application.RequestResponseUseCase
import com.example.stolaar.common.domain.annotations.UseCase
import com.example.stolaar.domain.service.CompanyService

@UseCase
class GetOneCompanyUseCase(
    private val CompanyService: CompanyService
): RequestResponseUseCase<String, CompanyResponseDTO> {

    override fun execute(request: String): CompanyResponseDTO {
        return CompanyDTOMapper.mapToDTO(CompanyService.findById(request))
    }

}