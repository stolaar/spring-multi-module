package com.example.stolaar.infrastructure.persistence.mapper

import com.example.stolaar.common.infrastructure.persistence.EntityMapper
import com.example.stolaar.domain.model.Company
import com.example.stolaar.infrastructure.persistence.entity.CompanyEntity
import java.time.LocalDateTime
import java.util.UUID

object CompanyEntityMapper : EntityMapper<Company, CompanyEntity> {
    override fun mapToEntity(obj: Company): CompanyEntity {
        return with(obj) {
            CompanyEntity(
                id = id ?: UUID.randomUUID(),
                name = name,
                status = status,
                createdAt = LocalDateTime.now()
            )
        }
    }

    override fun mapFromEntity(obj: CompanyEntity): Company {
        return with(obj) {
            Company(
                id = id,
                name = name,
                status = status,
                createdAt = createdAt
            )
        }
    }
}