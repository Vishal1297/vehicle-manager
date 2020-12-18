package com.fretron.vehicleManager.di.module

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
    fun providesResourceConfig(vehicleResource: VehicleResource): ResourceConfig {
        return ResourceConfig().register(vehicleResource)
    }

    @Provides
    fun providesServer(@Named("host.url") host: String, @Named("host.port") port: Int, config: ResourceConfig): HttpServer {
        val url = UriBuilder.fromUri(host).port(port).build()
        return GrizzlyHttpServerFactory.createHttpServer(
            url,
            config
        )
    }

}