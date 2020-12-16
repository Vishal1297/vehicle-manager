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
        return "{\"uuid\":\"c70534f9-10fe-41d6-afbc-863d1984c68d\",\"registrationNumber\":\"11\",\n" +
                "\"driverName\":\"Driver Name\",\"bodyType\":\"Type-1\",\"chasisType\":\"Type-2\",\n" +
                "\"carringCapacity\":\"40\"}"
    }

    fun getVehicle(): Vehicle {
        val jsonString = "{\"uuid\": \"c70534f9-10fe-41d6-afbc-863d1984c68d\", \n" +
                "\"registrationNumber\": \"12\", \"driverName\": \"Driver Name\", \"bodyType\": \"Type-1\", \n" +
                "\"chasisType\": \"Type-2\", \"carringCapacity\": \"40\"}"

        return objectMapper.readValue(jsonString, Vehicle::class.java)
    }

    fun updateVehicleRequest(): String {
        return "{\n" +
                "  \"uuid\": \"c70534f9-10fe-41d6-afbc-863d1888c68d\",\n" +
                "  \"registrationNumber\": \"14\",\n" +
                "  \"driverName\": \"Driver\",\n" +
                "  \"bodyType\": \"Type-3\",\n" +
                "  \"chasisType\": \"Type-4\",\n" +
                "  \"carringCapacity\": \"45\"\n" +
                "}";
    }

}
