package com.fretron.vehicleManager.repository

import com.fretron.vehicleManager.model.Vehicle
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Inject
import javax.inject.Named

class VehicleRepositoryImpl
@Inject constructor(@Named("objectMapper") private val objectMapper: ObjectMapper) : VehicleRepository
{

    override fun createVehicle(vehicle: String): Vehicle = Vehicle()

    override fun getVehicle(id: String): Vehicle = Vehicle()

    override fun getAllVehicles(): List<Vehicle> = listOf()

    override fun updateVehicle(id: String, vehicle: String): Vehicle = Vehicle()

    override fun deleteVehicle(id: String): Vehicle = Vehicle()

}