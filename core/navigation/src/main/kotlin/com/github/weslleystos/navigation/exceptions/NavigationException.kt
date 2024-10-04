package com.github.weslleystos.navigation.exceptions

class NavigationException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Throwable(message, cause)
