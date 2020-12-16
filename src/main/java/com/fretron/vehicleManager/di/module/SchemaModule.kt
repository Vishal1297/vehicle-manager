package com.fretron.vehicleManager.di.module

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class SchemaModule {

    @Singleton
    @Provides
    @Named("objectMapper")
    fun getObjectMapper(): ObjectMapper = ObjectMapper()

}