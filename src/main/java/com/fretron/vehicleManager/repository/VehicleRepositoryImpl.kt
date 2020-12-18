package com.fretron.vehicleManager.repository

import com.fretron.vehicleManager.model.Vehicle
import org.codehaus.jackson.map.ObjectMapper
import javax.inject.Inject

class VehicleRepositoryImpl
@Inject constructor(private val objectMapper: ObjectMapper) : VehicleRepository {

    override fun createVehicle(vehicle: Vehicle): Vehicle = vehicle

    override fun getVehicle(id: String): Vehicle = Vehicle()

    override fun getAllVehicles(): List<Vehicle> = listOf()

    override fun updateVehicle(id: String, vehicle: Vehicle): Vehicle = Vehicle()

    override fun deleteVehicle(id: String): Vehicle = Vehicle()

}