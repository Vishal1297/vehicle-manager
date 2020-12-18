package com.fretron.vehicleManager.resource

import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.service.VehicleService
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Inject
import javax.inject.Named
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/vehicles/v1")
class VehicleResource @Inject constructor(
    private val objectMapper: ObjectMapper,
    private val vehicleServiceImpl: VehicleService
) {

    @POST
    @Path("/vehicle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun addVehicle(request: String): Response {
        val vehicle = vehicleServiceImpl.createVehicle(objectMapper.readValue(request, Vehicle::class.java))
//        println("addVehicle Resource $vehicle")
        return Response.ok(vehicle.toString()).build()
    }

    @GET
    @Path("/vehicle")
    @Produces(MediaType.APPLICATION_JSON)
    fun getVehicle(@QueryParam("uuid") id: String): Response {
        val vehicle = vehicleServiceImpl.getVehicle(id)
        return Response.ok().build()
    }

    @GET
    @Path("/vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllVehicles(): Response {
        val vehicle = vehicleServiceImpl.getAllVehicles()
        return Response.ok().build()
    }

    @PUT
    @Path("/vehicle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateVehicle(@QueryParam("uuid") id: String, request: String): Response {
        val vehicle = vehicleServiceImpl.updateVehicle(id, objectMapper.readValue(request, Vehicle::class.java))
        return Response.ok().build()
    }

    @DELETE
    @Path("/vehicle")
    @Produces(MediaType.APPLICATION_JSON)
    fun removeVehicle(@QueryParam("uuid") id: String): Response {
        val vehicle = vehicleServiceImpl.deleteVehicle(id)
        return Response.ok().build()
    }

}