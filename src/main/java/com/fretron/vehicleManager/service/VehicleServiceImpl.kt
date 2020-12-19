package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.exceptions.FretronException
import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepository
import javax.inject.Inject
import kotlin.jvm.Throws

class VehicleServiceImpl
@Inject constructor(private val vehicleRepository: VehicleRepository) {

    @Throws(FretronException::class)
    fun createVehicle(vehicle: Vehicle): Vehicle {
        print("2 Service")
        if (vehicle.getRegistrationNumber() == null || vehicle.getChassisType() == null) {
            throw FretronException("Either Registration Or Chassis Number Is Invalid")
        }
        print("2 Service $vehicle")
        return vehicleRepository.createVehicle(vehicle)
    }

    @Throws(FretronException::class)
    fun getVehicle(id: String): Vehicle {
        if (id.isEmpty()) throw FretronException("Invalid Vehicle Id : $id")
        return vehicleRepository.getVehicle(id)
    }

    fun getAllVehicles(): List<Vehicle> = vehicleRepository.getAllVehicles()

    @Throws(FretronException::class)
    fun updateVehicle(id: String, vehicle: Vehicle): Vehicle {
        if (id.isEmpty()) throw FretronException("Invalid Vehicle Id")
        else if (vehicle.getRegistrationNumber() == null || vehicle.getChassisType() == null) {
            throw FretronException("Either Registration Or Chassis Number Is Invalid")
        }
        return vehicleRepository.updateVehicle(id, vehicle)
    }

    @Throws(FretronException::class)
    fun deleteVehicle(id: String): Vehicle {
        if (id.isEmpty()) throw FretronException("Invalid Vehicle Id : $id")
        return vehicleRepository.deleteVehicle(id)
    }
}