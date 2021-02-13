package com.fretron.vehicleManager.di.modules

import com.fretron.vehicleManager.AppConstants
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
    @Named("vehicleRepositoryImpl")
    fun providesVehicleRepositoryImpl(
        objectMapper: ObjectMapper,
        database: MongoDatabase,
        @Named(AppConstants.KEY_VEHICLE_COLLECTION_NAME) vehicleCollectionName: String
    ): VehicleRepository {
        return VehicleRepositoryImpl(objectMapper, database, vehicleCollectionName)
    }

}