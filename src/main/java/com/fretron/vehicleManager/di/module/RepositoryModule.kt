package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.repository.VehicleRepository
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.mongodb.client.MongoDatabase
import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    fun providesUserRepository(objectMapper: ObjectMapper, database: MongoDatabase, @Named("vehicle.collection.name") collectionName: String): VehicleRepository {
        return VehicleRepositoryImpl(objectMapper, database, collectionName)
    }

}