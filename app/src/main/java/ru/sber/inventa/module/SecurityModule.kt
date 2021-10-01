package ru.sber.inventa.module

import dagger.Module
import dagger.Provides
import ru.sber.inventa.service.SecurityService

@Module
class SecurityModule {

    @Provides
    fun provideSecurityService(): SecurityService {
        return SecurityService()
    }

}