package ru.sber.inventa.service

class SecurityService {

    fun checkUser(login: String, password: String): Boolean {
        return login.length == password.length
    }
}