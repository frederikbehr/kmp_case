package org.example.kmp_case

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform