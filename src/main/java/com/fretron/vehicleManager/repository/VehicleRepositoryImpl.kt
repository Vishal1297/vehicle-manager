package com.fretron.vehicleManager.repository

import com.fretron.vehicleManager.AppConstants.KEY_VEHICLE_COLLECTION_NAME
import com.fretron.vehicleManager.exceptions.MongoDbException
import com.fretron.vehicleManager.model.Vehicle
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.util.JSON
import org.bson.Document
import org.bson.conversions.Bson
import org.codehaus.jackson.map.ObjectMapper
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class VehicleRepositoryImpl
@Inject constructor(
    private val objectMapper: ObjectMapper,
    private val database: MongoDatabase,
    @Named(KEY_VEHICLE_COLLECTION_NAME) private val vehicleCollectionName: String
) : VehicleRepository {

    @Throws(MongoDbException::class)
    override fun createVehicle(vehicle: Vehicle): Vehicle {
        val collection = database.getCollection(vehicleCollectionName)
        val document = Document.parse(vehicle.toString())
        document["_id"] = vehicle.getUuid()
        if (document == null) {
            throw MongoDbException("Vehicle Not Created")
        }
        collection.insertOne(document)
        return vehicle
    }

    @Throws(MongoDbException::class)
    override fun getVehicle(id: String): Vehicle {
        val collection = database.getCollection(vehicleCollectionName)
        val query = BasicDBObject()
        query["_id"] = id
        val mongoCursor = collection.find(query).limit(1).iterator()
        if (mongoCursor.hasNext()) {
            val document = mongoCursor.next()
            document.remove("_id")
            val json = JSON.serialize(document)
            return objectMapper.readValue(json, Vehicle::class.java)
        }
        throw MongoDbException("Vehicle Not Found At UUID :: $id")
    }

    @Throws(MongoDbException::class)
    override fun getAllVehicles(): List<Vehicle> {
        val vehicles: ArrayList<Vehicle> = ArrayList()
        val collection = database.getCollection(vehicleCollectionName)
        val mongoCursor = collection.find().iterator()
        while (mongoCursor.hasNext()) {
            val document = mongoCursor.next()
            val json = JSON.serialize(document)
            val vehicle = objectMapper.readValue(json, Vehicle::class.java)
            vehicles.add(vehicle)
        }
        return vehicles
    }

    @Throws(MongoDbException::class)
    override fun updateVehicle(id: String, vehicle: Vehicle): Vehicle {
        val collection = database.getCollection(vehicleCollectionName)
        val query = BasicDBObject()
        query["_id"] = id
        val personDocument = Document.parse(vehicle.toString())
        val update: Bson = Document("\$set", personDocument)
        val mongoCollection = collection.findOneAndUpdate(query, update)
        if (mongoCollection == null) throw MongoDbException("Vehicle Not Updated")
        else return vehicle
    }

    @Throws(MongoDbException::class)
    override fun deleteVehicle(id: String): Vehicle {
        val vehicle = getVehicle(id)
        val collection = database.getCollection(vehicleCollectionName)
        val mongoCollection = collection.deleteOne(Filters.eq("_id", id))
        if (mongoCollection.deletedCount == "1".toLong()) return vehicle
        else throw throw MongoDbException("Vehicle Not Deleted")
    }

}