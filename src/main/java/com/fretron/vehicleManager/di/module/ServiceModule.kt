package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.fretron.vehicleManager.service.VehicleService
import com.fretron.vehicleManager.service.VehicleServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ServiceModule {

    @Provides
    @Named("vehicleServiceImpl")
    fun provideService(@Named("vehicleRepositoryImpl") vehicleRepository: VehicleRepositoryImpl): VehicleService =
        VehicleServiceImpl(vehicleRepository)

}