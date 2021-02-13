package com.fretron.vehicleManager.di.component

import com.fretron.vehicleManager.di.modules.*
import dagger.Component
import org.glassfish.grizzly.http.server.HttpServer
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ConfigModule::class, HttpModule::class,
        SchemaModule::class, RepositoryModule::class, DatabaseModule::class]
)
interface VehicleAppComponent {

    fun server(): HttpServer

}