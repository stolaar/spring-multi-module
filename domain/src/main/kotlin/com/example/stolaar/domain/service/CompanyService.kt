package com.example.stolaar.domain.service

import com.example.stolaar.domain.model.Company
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CompanyService {
    fun findAll(pageable: Pageable): Page<Company>
    fun findById(id: String): Company
    fun save(Company: Company): Company
    fun update(Company: Company): Company
    fun delete(id: String)
}