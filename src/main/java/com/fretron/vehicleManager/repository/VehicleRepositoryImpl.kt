package com.fretron.vehicleManager.repository

import com.fretron.vehicleManager.AppConstants.KEY_VEHICLE_COLLECTION_NAME
import com.fretron.vehicleManager.exceptions.MongoDbException
import com.fretron.vehicleManager.model.Vehicle
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.FindOneAndUpdateOptions
import com.mongodb.client.model.ReturnDocument
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

    private var collection: MongoCollection<Document>

    init {
        collection = database.getCollection(vehicleCollectionName)
    }

    @Throws(MongoDbException::class)
    override fun createVehicle(vehicle: Vehicle): Vehicle {
        val collection = database.getCollection(vehicleCollectionName)
        val document = Document.parse(vehicle.toString())
        document["_id"] = vehicle.getUuid()
        if (document == null) {
            throw MongoDbException("Vehicle not created at id ${vehicle.getUuid()}")
        }
        collection.insertOne(document)
        return vehicle
    }

    @Throws(MongoDbException::class)
    override fun getVehicle(id: String): Vehicle? {
        try {
            val query = BasicDBObject()
            query["_id"] = id
            val mongoCursor = collection.find(query).limit(1).iterator()
            if (mongoCursor.hasNext()) {
                val document = mongoCursor.next()
                document.remove("_id")
                val json = JSON.serialize(document)
                return objectMapper.readValue(json, Vehicle::class.java)
            }
        }catch (ex : Exception){
            throw MongoDbException("Vehicle not found id :: $id")
        }
        return null
    }

    @Throws(MongoDbException::class)
    override fun getAllVehicles(): List<Vehicle> {
        val vehicles: ArrayList<Vehicle> = ArrayList()
        try {
            val mongoCursor = collection.find().iterator()
            while (mongoCursor.hasNext()) {
                val document = mongoCursor.next()
                val json = JSON.serialize(document)
                val vehicle = objectMapper.readValue(json, Vehicle::class.java)
                vehicles.add(vehicle)
            }
            return vehicles
        }catch (ex: Exception){
            throw MongoDbException("Unable to get all vehicles")
        }
    }

    @Throws(MongoDbException::class)
    override fun updateVehicle(id: String, vehicle: Vehicle): Vehicle {
        try {
            val query = BasicDBObject()
            query["_id"] = id
            val personDocument = Document.parse(vehicle.toString())
            val update: Bson = Document("\$set", personDocument)
            val updatedVehicleDocument = collection.findOneAndUpdate(query, update, FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER))
            updatedVehicleDocument ?: throw MongoDbException("Vehicle Not Updated")
            val json = JSON.serialize(updatedVehicleDocument)
            return objectMapper.readValue(json, Vehicle::class.java)
        }catch (ex : Exception){
            throw MongoDbException("Unable to update vehicle at id $id")
        }
    }

    @Throws(MongoDbException::class)
    override fun deleteVehicle(id: String): Vehicle {
        try {
            val deletedVehicleDocument = collection.findOneAndDelete(Filters.eq("_id", id))
            deletedVehicleDocument ?: throw MongoDbException("Vehicle Not Deleted")
            val json = JSON.serialize(deletedVehicleDocument)
            return objectMapper.readValue(json, Vehicle::class.java)
        }catch (ex : Exception) {
            throw MongoDbException("Unable to delete vehicle at id $id")
        }
    }

}