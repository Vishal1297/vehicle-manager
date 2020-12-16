package com.fretron.vehicleManager.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConfigModule {

    private val HOST_NAME: String = "http://0.0.0.0"
    private val PORT: Int = 8080

    @Provides
    @Named("host.url")
    fun provideHost(): String {
        return HOST_NAME
    }

    @Provides
    @Named("host.port")
    fun providePort(): Int {
        return PORT
    }

}