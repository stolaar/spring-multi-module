package com.example.stolaar.infrastructure.service

import com.example.stolaar.domain.constants.Exceptions
import com.example.stolaar.domain.model.Company
import com.example.stolaar.domain.service.CompanyService
import org.springframework.stereotype.Service
import com.example.stolaar.infrastructure.persistence.mapper.CompanyEntityMapper
import com.example.stolaar.infrastructure.persistence.repository.CompanyRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CompanyServiceImpl(
    private val CompanyRepository: CompanyRepository
) : CompanyService {

    override fun findAll(pageable: Pageable): Page<Company> {
        return CompanyRepository.findAll(pageable)
            .map(CompanyEntityMapper::mapFromEntity)
    }

    override fun findById(id: String): Company {
        return CompanyRepository.findById(UUID.fromString(id))
            .map(CompanyEntityMapper::mapFromEntity)
            .orElseThrow { Exceptions.COMPANY_NOT_FOUND }
    }


    @Transactional
    override fun save(Company: Company): Company {
        return CompanyEntityMapper.mapFromEntity(
            CompanyRepository.save(
                CompanyEntityMapper.mapToEntity(Company)
            )
        )
    }

    @Transactional
    override fun update(Company: Company): Company {
        this.findById(Company.id.toString())

        return CompanyEntityMapper.mapFromEntity(
            CompanyRepository.save(
                CompanyEntityMapper.mapToEntity(Company)
            )
        )
    }

    override fun delete(id: String) {
        CompanyRepository.findById(UUID.fromString(id))
            .flatMap {
                CompanyRepository.delete(it)
                Optional.of(it)
            }.orElseThrow { Exceptions.COMPANY_NOT_FOUND }

    }

}