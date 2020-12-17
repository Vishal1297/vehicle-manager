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
                "    \"uuid\": \"c70534f9-10fe-41d6-afbc-863d1984c68d\",\n" +
                "    \"registrationNumber\": \"11\",\n" +
                "    \"driverName\": \"Driver Name\",\n" +
                "    \"bodyType\": \"Type-1\",\n" +
                "    \"chassisType\": \"Type-2\",\n" +
                "    \"carryingCapacity\": \"40\"\n" +
                "}"
    }

    fun getVehicle(): Vehicle {
        val jsonString = "{\n" +
                "    \"uuid\": \"c70534f9-10fe-41d6-afbc-863d1984c68d\",\n" +
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
                "    \"uuid\": \"c70534f9-10fe-41d6-afbc-863d1004c68d\",\n" +
                "    \"registrationNumber\": \"11\",\n" +
                "    \"driverName\": \"Driver Name\",\n" +
                "    \"bodyType\": \"Type-1\",\n" +
                "    \"chassisType\": \"Type-2\",\n" +
                "    \"carryingCapacity\": \"40\"\n" +
                "}"
    }

}
