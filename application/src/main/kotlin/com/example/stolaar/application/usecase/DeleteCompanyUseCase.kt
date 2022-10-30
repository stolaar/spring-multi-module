package com.example.stolaar.application.usecase

import com.example.stolaar.common.application.RequestUseCase
import com.example.stolaar.common.domain.annotations.UseCase
import com.example.stolaar.domain.service.CompanyService

@UseCase
class DeleteCompanyUseCase(
    private val CompanyService: CompanyService
) : RequestUseCase<String> {

    override fun execute(request: String) {
        CompanyService.delete(request)
    }

}