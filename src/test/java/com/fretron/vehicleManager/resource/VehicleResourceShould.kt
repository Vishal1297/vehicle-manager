package com.fretron.vehicleManager.resource

import com.fretron.vehicleManager.helper.TestDataSource
import com.fretron.vehicleManager.service.VehicleServiceImpl
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jettison.json.JSONObject
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.test.JerseyTest
import org.junit.Assert.assertTrue
import org.junit.Test
import javax.ws.rs.client.Entity
import javax.ws.rs.core.Application
import javax.ws.rs.core.MediaType

class VehicleResourceShould : JerseyTest() {

    private val baseUrl = "/vehicles/v1"
    private lateinit var uuid: String
    private lateinit var objectMapper: ObjectMapper
    private lateinit var vehicleServiceImpl: VehicleServiceImpl
    private lateinit var vehicleResource: VehicleResource

    override fun configure(): Application {
        objectMapper = mock()
        vehicleServiceImpl = mock()
        val config = ResourceConfig()
        vehicleResource = VehicleResource(objectMapper, vehicleServiceImpl)
        config.register(vehicleResource)
        return config.application
    }

    @Test
    fun return_200_after_create_vehicle() {
        val vehicleRequest = TestDataSource.createVehicleRequest()
        whenever(vehicleServiceImpl.createVehicle(any())).thenReturn(TestDataSource.getVehicle())
        val response =
            target("$baseUrl/vehicle").request().post(Entity.entity(vehicleRequest, MediaType.APPLICATION_JSON_TYPE))
        assertTrue(response.status == 200)
        val data = (response.readEntity(String::class.java))
        println(data)
        val responseJson = JSONObject(data)
        println("return_200_after_create_vehicle :: $responseJson")
        uuid = responseJson.getJSONObject("data").getString("uuid")
        println("uuid :: $uuid")
    }

    @Test
    fun return_200_after_get_vehicle_by_uuid() {
        return_200_after_create_vehicle()
        val response = target("$baseUrl/device/$uuid").request().get()
        println("\nresponse is $response")
        assertTrue("return_200_after_get_vehicle_by_uuid :: ", response.status == 200)
        println("return_200_after_get_vehicle_by_uuid :: ${response.readEntity(String::class.java)}")
    }

    @Test
    fun return_200_after_get_all_vehicles() {
        whenever(vehicleServiceImpl.getAllVehicles()).thenReturn(
            listOf(TestDataSource.getVehicle())
        )
        val response = target("$baseUrl/vehicles").request().get()
        println("return_200_after_get_all_vehicles :: $response.readEntity(String::class.java)")
        assert(response.status==200)
    }

    @Test
    fun return_200_after_update_vehicle() {
        return_200_after_create_vehicle()
        val updateRequest = TestDataSource.updateVehicleRequest()
        val testData = JSONObject(updateRequest)
        testData.remove("uuid")
        testData.put("uuid", uuid)
        val response =
            target("$baseUrl/vehicle").request().put(Entity.entity(testData.toString(), MediaType.APPLICATION_JSON))
        println("response is $response")
        assertTrue("return_200_after_update_vehicle", response.status == 200)
    }

    @Test
    fun return_200_after_delete_device_by_uuid() {
        return_200_after_get_vehicle_by_uuid()
        val deletedData = TestDataSource.createVehicleRequest()
        println("\nreturn_200_after_delete_devices :: $deletedData")
        val response = target("$baseUrl/devices/$uuid").request().delete()
        print("\nreturn_200_after_delete_device :: $response")
        assertTrue("return_200_after_delete_device_by_uuid :: ", response.status == 200)
    }

}