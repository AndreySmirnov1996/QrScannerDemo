package ru.sber.module

import dagger.Module
import dagger.Provides
import ru.sber.service.SecurityService

@Module
class SecurityModule {

    @Provides
    fun provideSecurityService(): SecurityService {
        return SecurityService()
    }

}