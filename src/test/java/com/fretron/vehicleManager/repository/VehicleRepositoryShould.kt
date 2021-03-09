package com.fretron.vehicleManager.repository

import com.fretron.vehicleManager.AppConstants
import com.fretron.vehicleManager.helper.TestDataSource
import com.fretron.vehicleManager.utils.EmbeddedMongoDb
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.codehaus.jackson.map.ObjectMapper
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.util.*

class VehicleRepositoryShould {

    private lateinit var embeddedMongoDb: EmbeddedMongoDb
    private lateinit var database: MongoDatabase
    private val objectMapper = ObjectMapper()

    @Before
    fun configure() {
        startMongoDb()
        val mongoClient = MongoClient("localhost", embeddedMongoDb.port)
        database = mongoClient.getDatabase("vehicle")
    }

    @After
    fun closeConnections() {
        embeddedMongoDb.stop()
    }

    private fun startMongoDb() {
        val rand = Random()
        val n = rand.nextInt(99) + 9900
        embeddedMongoDb = EmbeddedMongoDb(n)
        embeddedMongoDb.start()
    }

    @Test
    fun createVehicleTest() {
        val classUnderTest = VehicleRepositoryImpl(objectMapper, database, AppConstants.DB_COLLECTION_NAME)
        val vehicle = TestDataSource.getVehicle()
        val vehicleCreated = classUnderTest.createVehicle(vehicle)
        assertNotNull(vehicleCreated)
        print(vehicleCreated.toString())
    }

    @Test
    fun getVehicleTest() {
        val classUnderTest = VehicleRepositoryImpl(objectMapper, database, AppConstants.DB_COLLECTION_NAME)
        val vehicle = TestDataSource.getVehicle()
        vehicle.setUuid(UUID.randomUUID().toString())
        val vehicleCreated = classUnderTest.createVehicle(vehicle)
        val vehicleFromDb = classUnderTest.getVehicle(vehicleCreated.getUuid())
        println(vehicleFromDb)
        assertNotNull(vehicleFromDb)
        print(vehicleFromDb.toString())
    }

    @Test
    fun getAllVehiclesTest() {
        val classUnderTest = VehicleRepositoryImpl(objectMapper, database, AppConstants.DB_COLLECTION_NAME)
        val vehicles = classUnderTest.getAllVehicles()
        assertNotNull(vehicles)
        print(vehicles.toString())
    }

    @Test
    fun updateVehicleTest() {
        val classUnderTest = VehicleRepositoryImpl(objectMapper, database, AppConstants.DB_COLLECTION_NAME)
        val vehicle = TestDataSource.getVehicle()
        vehicle.setUuid(UUID.randomUUID().toString())
        val vehicleCreated = classUnderTest.createVehicle(vehicle)
        val updatedVehicle = classUnderTest.updateVehicle(vehicleCreated.getUuid(), vehicle)
        assertNotNull(updatedVehicle)
        print(updatedVehicle.toString())
    }

    @Test
    fun deleteVehicleTest() {
        val classUnderTest = VehicleRepositoryImpl(objectMapper, database, AppConstants.DB_COLLECTION_NAME)
        val vehicle = TestDataSource.getVehicle()
        vehicle.setUuid(UUID.randomUUID().toString())
        val vehicleCreated = classUnderTest.createVehicle(vehicle)
        val deletedVehicle = classUnderTest.deleteVehicle(vehicleCreated.getUuid())
        assertNotNull(deletedVehicle)
        print(deletedVehicle.toString())
    }

}