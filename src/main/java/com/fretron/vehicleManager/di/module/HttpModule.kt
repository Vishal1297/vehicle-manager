package com.fretron.vehicleManager.di.module

import com.fretron.vehicleManager.AppConstants.KEY_SERVER_HOST
import com.fretron.vehicleManager.AppConstants.KEY_SERVER_PORT
import com.fretron.vehicleManager.exceptions.mapper.FretronExceptionMapper
import com.fretron.vehicleManager.resource.VehicleResource
import dagger.Module
import dagger.Provides
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import javax.inject.Named
import javax.ws.rs.core.UriBuilder

@Module
class HttpModule {

    @Provides
    fun providesResourceConfig(
        vehicleResource: VehicleResource,
        fretronExceptionMapper: FretronExceptionMapper
    ): ResourceConfig {
        return ResourceConfig()
            .register(vehicleResource)
            .register(fretronExceptionMapper)
    }

    @Provides
    fun providesServer(
        @Named(KEY_SERVER_HOST) host: String,
        @Named(KEY_SERVER_PORT) port: Int,
        config: ResourceConfig
    ): HttpServer {
        val url = UriBuilder.fromUri(host).port(port).build()
        return GrizzlyHttpServerFactory.createHttpServer(
            url,
            config
        )
    }

}