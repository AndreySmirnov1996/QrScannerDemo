package ru.sber.inventa.component

import dagger.Component
import ru.sber.inventa.activity.LoginActivity
import ru.sber.inventa.module.SecurityModule

@Component(modules = [SecurityModule::class])
interface AppComponent {

    fun injectLoginActivity(loginActivity: LoginActivity)
}