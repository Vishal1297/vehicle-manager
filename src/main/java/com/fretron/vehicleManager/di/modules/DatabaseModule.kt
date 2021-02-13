package com.fretron.vehicleManager.di.modules

import com.fretron.vehicleManager.AppConstants
import com.fretron.vehicleManager.AppConstants.KEY_VEHICLE_COLLECTION_NAME
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
open class DatabaseModule {

    @Singleton
    @Provides
    fun provideMongoClient(): MongoClient {
        return MongoClient(AppConstants.DB_HOST, AppConstants.DB_PORT)
    }

    @Provides
    fun provideDatabase(
        mongoClient: MongoClient,
        @Named(KEY_VEHICLE_COLLECTION_NAME) collectionName: String
    ): MongoDatabase {
        return mongoClient.getDatabase(collectionName)
    }

}