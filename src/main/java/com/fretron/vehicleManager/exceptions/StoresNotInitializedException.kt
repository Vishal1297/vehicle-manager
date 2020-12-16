package com.fretron.vehicleManager.exceptions

class StoresNotInitializedException : FretronException {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
}