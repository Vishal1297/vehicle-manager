package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepository
import javax.inject.Inject
import javax.inject.Named

class VehicleServiceImpl
@Inject constructor(private val vehicleRepository: VehicleRepository) : VehicleService {
    override fun createVehicle(vehicle: Vehicle): Vehicle = vehicleRepository.createVehicle(vehicle)

    override fun getVehicle(id: String): Vehicle = vehicleRepository.getVehicle(id)

    override fun getAllVehicles(): List<Vehicle> = vehicleRepository.getAllVehicles()

    override fun updateVehicle(id: String, vehicle: Vehicle): Vehicle = vehicleRepository.updateVehicle(id, vehicle)

    override fun deleteVehicle(id: String): Vehicle = vehicleRepository.deleteVehicle(id)
}