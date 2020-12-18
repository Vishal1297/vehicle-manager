package com.fretron.vehicleManager.di.component

import com.fretron.vehicleManager.di.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ConfigModule::class, HttpModule::class, ResourceModule::class, ServiceModule::class, RepositoryModule::class, SchemaModule::class])
interface VehicleAppComponent {

}