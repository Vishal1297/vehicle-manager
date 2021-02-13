package com.fretron.vehicleManager.di.modules

import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Singleton

@Module
class SchemaModule {

    @Singleton
    @Provides
    fun providesObjectMapper(): ObjectMapper = ObjectMapper()

}