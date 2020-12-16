package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.repository.VehicleRepository
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    @Named("vehicleRepositoryImpl")
    fun provideUserRepository(objectMapper: ObjectMapper): VehicleRepository {
        return VehicleRepositoryImpl(objectMapper)
    }

}