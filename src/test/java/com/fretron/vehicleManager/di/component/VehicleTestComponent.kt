package com.fretron.vehicleManager.di.component

import com.fretron.vehicleManager.di.module.RepositoryModule
import com.fretron.vehicleManager.di.module.ResourceModule
import com.fretron.vehicleManager.di.module.SchemaModule
import com.fretron.vehicleManager.di.module.ServiceModule
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.fretron.vehicleManager.service.VehicleServiceImpl
import dagger.Component
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Singleton

@Singleton
@Component(modules = [ResourceModule::class, ServiceModule::class, RepositoryModule::class, SchemaModule::class])
interface VehicleTestComponent {

    fun objectMapper(): ObjectMapper
    fun vehicleRepository(): VehicleRepositoryImpl
    fun vehicleService(): VehicleServiceImpl

}