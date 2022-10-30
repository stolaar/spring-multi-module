package com.example.stolaar.application.usecase

import com.example.stolaar.application.mapper.CompanyDTOMapper
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.common.application.RequestResponseUseCase
import com.example.stolaar.common.domain.annotations.UseCase
import com.example.stolaar.domain.service.CompanyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@UseCase
class GetAllCompanyUseCase(
    private val CompanyService: CompanyService
) : RequestResponseUseCase<Pageable, Page<CompanyResponseDTO>> {

    override fun execute(request: Pageable): Page<CompanyResponseDTO> {
        return CompanyService.findAll(request).map(CompanyDTOMapper::mapToDTO)
    }

}