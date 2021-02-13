package com.fretron.vehicleManager.di.modules

import com.fretron.vehicleManager.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConfigModule {

    @Provides
    @Named(AppConstants.KEY_SERVER_HOST)
    fun providesHost(): String {
        return AppConstants.SERVER_HOST_NAME
    }

    @Provides
    @Named(AppConstants.KEY_SERVER_PORT)
    fun providesPort(): Int {
        return AppConstants.SERVER_PORT
    }

    @Provides
    @Named(AppConstants.KEY_VEHICLE_COLLECTION_NAME)
    fun providesDatabaseName(): String {
        return AppConstants.DB_COLLECTION_NAME
    }

}