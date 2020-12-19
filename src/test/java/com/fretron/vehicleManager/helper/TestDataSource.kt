package com.fretron.vehicleManager.helper

import com.fretron.vehicleManager.model.Vehicle
import org.codehaus.jackson.map.DeserializationConfig
import org.codehaus.jackson.map.ObjectMapper

object TestDataSource {

    private val objectMapper = ObjectMapper()

    init {
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, true)
    }

    fun createVehicleRequest(): String {
        return "{\n" +
                "    \"uuid\": \"1a1c5fe5-3ee0-453d-8425-5fec44961029\",\n" +
                "    \"registrationNumber\": \"11\",\n" +
                "    \"driverName\": \"Driver Name\",\n" +
                "    \"bodyType\": \"Type-1\",\n" +
                "    \"chassisType\": \"Type-2\",\n" +
                "    \"carryingCapacity\": \"40\"\n" +
                "}"
    }

    fun getVehicle(): Vehicle {
        val jsonString = "{\n" +
                "    \"uuid\": \"1a1c5fe5-3ee0-453d-8425-5fec44961029\",\n" +
                "    \"registrationNumber\": \"11\",\n" +
                "    \"driverName\": \"Driver Name\",\n" +
                "    \"bodyType\": \"Type-1\",\n" +
                "    \"chassisType\": \"Type-2\",\n" +
                "    \"carryingCapacity\": \"40\"\n" +
                "}"
        return objectMapper.readValue(jsonString, Vehicle::class.java)
    }

    fun updateVehicleRequest(): String {
        return "{\n" +
                "    \"uuid\": \"c70034f9-10fe-41d6-afbc-863d1994c68d\",\n" +
                "    \"registrationNumber\": \"11\",\n" +
                "    \"driverName\": \"Driver Name\",\n" +
                "    \"bodyType\": \"Type-1\",\n" +
                "    \"chassisType\": \"Type-2\",\n" +
                "    \"carryingCapacity\": \"40\"\n" +
                "}"
    }

    fun getUpdatedVehicle(): Vehicle {
        val jsonString = "{\n" +
                "    \"uuid\": \"c79934f9-10fe-41d6-afbc-863d1994c68d\",\n" +
                "    \"registrationNumber\": \"11\",\n" +
                "    \"driverName\": \"Driver Name\",\n" +
                "    \"bodyType\": \"Type-1\",\n" +
                "    \"chassisType\": \"Type-2\",\n" +
                "    \"carryingCapacity\": \"40\"\n" +
                "}"
        return objectMapper.readValue(jsonString, Vehicle::class.java)
    }

}
