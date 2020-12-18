package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.exceptions.FretronException
import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepository
import java.util.*
import javax.inject.Inject

class VehicleServiceImpl
@Inject constructor(private val vehicleRepository: VehicleRepository) : VehicleService {
    override fun createVehicle(vehicle: Vehicle): Vehicle {
        if (vehicle.getRegistrationNumber() == null || vehicle.getChassisType() == null) {
            throw FretronException("Either Registration Or Chassis Number Is Invalid")
        }
        vehicle.setUuid(UUID.randomUUID().toString())
        return vehicleRepository.createVehicle(vehicle)
    }

    override fun getVehicle(id: String): Vehicle {
        if (id.isEmpty()) throw FretronException("Invalid Vehicle Id")
        return vehicleRepository.getVehicle(id)
    }

    override fun getAllVehicles(): List<Vehicle> = vehicleRepository.getAllVehicles()

    override fun updateVehicle(id: String, vehicle: Vehicle): Vehicle {
        if (id.isEmpty()){
            throw FretronException("Invalid Vehicle Id")
        }else if (vehicle.getRegistrationNumber() == null || vehicle.getChassisType() == null){
            throw FretronException("Either Registration Or Chassis Number Is Invalid")
        }
        return vehicleRepository.updateVehicle(id, vehicle)
    }

    override fun deleteVehicle(id: String): Vehicle = vehicleRepository.deleteVehicle(id)
}