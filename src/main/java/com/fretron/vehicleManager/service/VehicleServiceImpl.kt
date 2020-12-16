package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepository
import javax.inject.Inject
import javax.inject.Named

class VehicleServiceImpl
@Inject constructor(@Named("vehicleRepositoryImpl") vehicleRepository: VehicleRepository) : VehicleService {
    override fun createVehicle(vehicle: String): Vehicle {
        return Vehicle()
    }

    override fun getVehicle(id: String): Vehicle {
        return Vehicle()
    }

    override fun getAllVehicles(): List<Vehicle> {
        return listOf()
    }

    override fun updateVehicle(id: String, vehicle: String): Vehicle {
        return Vehicle()
    }

    override fun deleteVehicle(id: String): Vehicle {
        return Vehicle()
    }
}