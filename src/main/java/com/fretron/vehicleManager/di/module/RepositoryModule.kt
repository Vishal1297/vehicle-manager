package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.AppConstants
import com.fretron.vehicleManager.repository.VehicleRepository
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.fretron.vehicleManager.resource.VehicleResource
import com.fretron.vehicleManager.service.VehicleServiceImpl
import com.mongodb.client.MongoDatabase
import dagger.Module
import dagger.Provides
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Named("vehicleRepositoryImpl")
    fun providesVehicleRepositoryImpl(
        objectMapper: ObjectMapper,
        database: MongoDatabase,
        @Named(AppConstants.KEY_VEHICLE_COLLECTION_NAME) vehicleCollectionName: String
    ): VehicleRepository {
        return VehicleRepositoryImpl(objectMapper, database, vehicleCollectionName)
    }

}