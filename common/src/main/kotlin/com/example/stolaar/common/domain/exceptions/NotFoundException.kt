package com.example.stolaar.common.domain.exceptions

class NotFoundException(override var message: String, var errorRef: String) : RuntimeException(message)