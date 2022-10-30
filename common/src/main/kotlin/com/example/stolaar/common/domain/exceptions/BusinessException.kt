package com.example.stolaar.common.domain.exceptions

class BusinessException(override var message: String) : RuntimeException(message)