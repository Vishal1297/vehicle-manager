package com.fretron.vehicleManager.repository

import com.fretron.vehicleManager.model.Vehicle

interface VehicleRepository {

    fun createVehicle(vehicle: String): Vehicle
    fun getVehicle(id: String): Vehicle
    fun getAllVehicles(): List<Vehicle>
    fun updateVehicle(id: String, vehicle: String): Vehicle
    fun deleteVehicle(id: String): Vehicle

}