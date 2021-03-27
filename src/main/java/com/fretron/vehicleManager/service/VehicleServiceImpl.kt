package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.AppConstants.NOT_FOUND
import com.fretron.vehicleManager.exceptions.FretronException
import com.fretron.vehicleManager.exceptions.NotAllowedException
import com.fretron.vehicleManager.exceptions.ResourceNotFoundException
import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepository
import org.apache.logging.log4j.LogManager
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class VehicleServiceImpl
@Inject constructor(@Named("vehicleRepositoryImpl") private val vehicleRepository: VehicleRepository) {

    @Throws(FretronException::class)
    fun createVehicle(vehicle: Vehicle): Vehicle {
        logger.info("CREATE VEHICLE Id : ${vehicle.uuid}")
        if (vehicle.registrationNumber == null || vehicle.chassisType == null) {
            throw NotAllowedException("Either Registration or Chassis Number is not provided")
        }
        vehicle.uuid = UUID.randomUUID().toString()
        if (getVehicle(vehicle.uuid) != null) throw NotAllowedException("Vehicle already exists with id : ${vehicle.uuid}")
        return vehicleRepository.createVehicle(vehicle)
    }

    @Throws(FretronException::class)
    fun getVehicle(id: String): Vehicle? {
        logger.info("GET VEHICLE Id : $id")
        return vehicleRepository.getVehicle(id)
    }

    @Throws(FretronException::class)
    fun getAllVehicles(): List<Vehicle> = vehicleRepository.getAllVehicles()

    @Throws(FretronException::class)
    fun updateVehicle(id: String, vehicle: Vehicle): Vehicle {
        logger.info("UPDATE VEHICLE Id : $id")
        if (id.isEmpty()) throw NotAllowedException("Invalid vehicle id")
        else if (vehicle.registrationNumber == null || vehicle.chassisType == null) {
            throw NotAllowedException("Either Registration Or Chassis Number is not provided")
        }
        val vehicleFromDB = vehicleRepository.getVehicle(id)
        vehicleFromDB?.uuid ?: throw ResourceNotFoundException("Vehicle to update $NOT_FOUND at id : $id")
        return vehicleRepository.updateVehicle(id, vehicle)
    }

    @Throws(FretronException::class)
    fun deleteVehicle(id: String): Vehicle {
        logger.info("DELETE VEHICLE Id : $id")
        if (id.isEmpty()) throw NotAllowedException("Invalid Vehicle Id : $id")
        getVehicle(id) ?: throw NotAllowedException("Vehicle to delete $NOT_FOUND : Id : $id")
        return vehicleRepository.deleteVehicle(id)
    }

    companion object {
        private val logger = LogManager.getLogger()
    }

}