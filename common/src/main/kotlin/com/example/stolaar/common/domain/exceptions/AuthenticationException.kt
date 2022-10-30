package com.example.stolaar.common.domain.exceptions

class AuthenticationException(override var message: String) : RuntimeException(message)