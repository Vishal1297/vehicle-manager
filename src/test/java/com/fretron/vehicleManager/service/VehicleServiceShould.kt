package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.helper.TestDataSource
import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class VehicleServiceShould {

    private lateinit var vehicleRepository: VehicleRepositoryImpl
    private lateinit var classUnderTest: VehicleServiceImpl
    private lateinit var uuid: String

    @Before
    fun setUp() {
        vehicleRepository = mock()
        classUnderTest = VehicleServiceImpl(vehicleRepository)
    }

    @Test
    fun createVehicleTest() {
        val vehicleToAdd = TestDataSource.getVehicle()
        whenever(vehicleRepository.createVehicle(any())).thenAnswer { invocation ->
            val args = invocation.arguments!!
            args[0] as Vehicle
        }
        val vehicle = classUnderTest.createVehicle(vehicleToAdd)
        assertNotNull(vehicle)
        uuid = vehicle.getUuid()
        assertNotNull(uuid)
        verify(vehicleRepository).createVehicle(vehicleToAdd)
    }

    @Test
    fun getVehicleTest() {
        createVehicleTest()
        whenever(vehicleRepository.getVehicle(any())).thenReturn(TestDataSource.getVehicle())
        assertNotNull(uuid)
        val vehicle = classUnderTest.getVehicle(uuid)
        assertNotNull(vehicle)
        verify(vehicleRepository).getVehicle(uuid)
    }

    @Test
    fun getAllVehiclesTest() {
        whenever(vehicleRepository.getAllVehicles()).thenReturn(listOf(TestDataSource.getVehicle()))
        val vehicles = classUnderTest.getAllVehicles()
        assertNotNull(vehicles)
        verify(vehicleRepository).getAllVehicles()
    }

    @Test
    fun updateVehicleTest() {
        getVehicleTest()
        val vehicle = TestDataSource.getUpdatedVehicle()
        whenever(
            vehicleRepository.updateVehicle(uuid, vehicle)
        ).thenReturn(TestDataSource.getVehicle())
        val updatedVehicle = classUnderTest.updateVehicle(uuid, vehicle)
        assertNotNull(updatedVehicle)
        verify(vehicleRepository).updateVehicle(uuid, vehicle)
    }

    @Test
    fun deleteVehicleTest() {
        getVehicleTest()
        whenever(
            vehicleRepository.deleteVehicle(uuid)
        ).thenReturn(TestDataSource.getVehicle())
        val deletedVehicle = classUnderTest.deleteVehicle(uuid)
        assertNotNull(deletedVehicle)
        verify(vehicleRepository).deleteVehicle(uuid)
    }

}