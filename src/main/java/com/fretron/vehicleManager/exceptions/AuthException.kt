package com.fretron.vehicleManager.exceptions

class AuthException : FretronException {
    constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
}