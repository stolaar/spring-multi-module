package com.example.stolaar.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.stolaar.infrastructure.persistence.entity.CompanyEntity
import java.util.UUID

@Repository
interface CompanyRepository : JpaRepository<CompanyEntity, UUID> {

}