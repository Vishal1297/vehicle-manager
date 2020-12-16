package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.model.Vehicle

interface VehicleService {
    fun createVehicle(vehicle: String): Vehicle
    fun getVehicle(id: String): Vehicle
    fun getAllVehicles(): List<Vehicle>
    fun updateVehicle(id: String, vehicle: String): Vehicle
    fun deleteVehicle(id: String): Vehicle
}