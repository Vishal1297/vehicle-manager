package com.fretron.vehicleManager.exceptions

class MongoDbException : FretronException {
    constructor() : super()
    constructor(msg: String?) : super(msg)
    constructor(msg: String?, e: Exception?) : super(msg, e)
}