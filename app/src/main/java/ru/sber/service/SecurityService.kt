package ru.sber.service

import kotlin.random.Random

class SecurityService {

    fun checkUser(): Boolean {
        return Random.nextBoolean()
    }
}