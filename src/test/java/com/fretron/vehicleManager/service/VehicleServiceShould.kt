package com.fretron.vehicleManager.service

import com.fretron.vehicleManager.helper.TestDataSource
import com.fretron.vehicleManager.model.Vehicle
import com.fretron.vehicleManager.repository.VehicleRepositoryImpl
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.inOrder
import com.nhaarman.mockito_kotlin.mock
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
        val inOrder = inOrder(vehicleRepository)
        val vehicleToAdd = TestDataSource.getVehicle()

        whenever(vehicleRepository.createVehicle(any())).thenAnswer { invocation ->
            val args = invocation.arguments
            println(args[0])
            args[0] as Vehicle
        }
        val vehicle = classUnderTest.createVehicle(vehicleToAdd)
        assertNotNull(vehicle)
        inOrder.verify(vehicleRepository)
    }

    @Test
    fun getVehicleTest() {
//        createVehicleTest()
//        val inOrder = inOrder(vehicleRepository)
//        whenever(vehicleRepository.getVehicle(any())).thenAnswer { invocation ->
//            val args = invocation.arguments
//            println(args[0])
//            args[0] as Vehicle
//        }
//        val vehicle = classUnderTest.getVehicle(uuid)
//        assertNotNull(vehicle)
//        print(vehicle)
//        inOrder.verify(vehicleRepository)
    }

    @Test
    fun getAllVehiclesTest() {

    }

    @Test
    fun updateVehicleTest() {

    }

    @Test
    fun deleteVehicleTest() {

    }

}