package com.fretron.vehicleManager.exceptions

class ProducerException : FretronException {
    constructor() : super() {}
    constructor(msg: String?, ex: Exception?) : super(msg, ex) {}
    constructor(msg: String?) : super(msg) {}
}