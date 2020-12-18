package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.resource.VehicleResource
import com.fretron.vehicleManager.service.VehicleService
import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Singleton

@Module
class ResourceModule {

    @Singleton
    @Provides
    fun providesVehicleResource(
        objectMapper: ObjectMapper,
        vehicleServiceImpl: VehicleService
    ): VehicleResource {
        return VehicleResource(objectMapper, vehicleServiceImpl)
    }

}