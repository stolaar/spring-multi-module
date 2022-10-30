package com.example.stolaar.common.infrastructure.persistence

interface EntityMapper<Domain, Entity> {
    fun mapToEntity(obj: Domain): Entity
    fun mapFromEntity(obj: Entity): Domain
}