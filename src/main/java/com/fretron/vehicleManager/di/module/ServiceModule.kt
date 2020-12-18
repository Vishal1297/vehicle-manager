package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.fretron.vehicleManager.service.VehicleServiceImpl
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun providesVehicleService(vehicleRepository: VehicleRepositoryImpl):
            VehicleServiceImpl = VehicleServiceImpl(vehicleRepository)

}