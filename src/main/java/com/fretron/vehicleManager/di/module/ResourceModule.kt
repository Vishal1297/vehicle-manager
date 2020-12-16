package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.resource.VehicleResource
import com.fretron.vehicleManager.service.VehicleService
import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Named
import javax.inject.Singleton

@Module
class ResourceModule {

    @Singleton
    @Provides
    fun provideVehicleResource(
        @Named("objectMapper") objectMapper: ObjectMapper,
        @Named("vehicleServiceImpl") vehicleServiceImpl: VehicleService
    ): VehicleResource {
        return VehicleResource(objectMapper, vehicleServiceImpl)
    }

}