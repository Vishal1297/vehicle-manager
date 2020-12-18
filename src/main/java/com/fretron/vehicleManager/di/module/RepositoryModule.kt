package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper

@Module
class RepositoryModule {

    @Provides
    fun providesUserRepository(objectMapper: ObjectMapper): VehicleRepositoryImpl {
        return VehicleRepositoryImpl(objectMapper)
    }

}