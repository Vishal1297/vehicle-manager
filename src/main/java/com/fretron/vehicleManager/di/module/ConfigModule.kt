package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConfigModule {

    @Provides
    @Named("host.url")
    fun providesHost(): String {
        return AppConstants.SERVER_HOST_NAME
    }

    @Provides
    @Named("host.port")
    fun providesPort(): Int {
        return AppConstants.SERVER_PORT
    }

    @Provides
    @Named("vehicle.collection.name")
    fun providesDatabaseName(): String {
        return AppConstants.DB_COLLECTION_NAME
    }

}