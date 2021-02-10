package com.fretron.vehicleManager.di.component

import com.fretron.vehicleManager.di.module.*
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.fretron.vehicleManager.service.VehicleServiceImpl
import dagger.Component
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ConfigModule::class, RepositoryModule::class,
        SchemaModule::class, DatabaseModule::class]
)
interface VehicleTestComponent {

    fun objectMapper(): ObjectMapper
    fun vehicleRepository(): VehicleRepositoryImpl
    fun vehicleService(): VehicleServiceImpl

}