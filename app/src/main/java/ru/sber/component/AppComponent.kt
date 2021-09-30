package ru.sber.component

import dagger.Component
import ru.sber.activity.LoginActivity
import ru.sber.module.SecurityModule

@Component(modules = [SecurityModule::class])
interface AppComponent {

    fun injectLoginActivity(loginActivity: LoginActivity)
}