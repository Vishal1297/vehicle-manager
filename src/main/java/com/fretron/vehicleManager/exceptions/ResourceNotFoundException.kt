package com.fretron.vehicleManager.exceptions

class ResourceNotFoundException : FretronException {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
}