package com.fretron.vehicleManager.exceptions

class NotAllowedException : FretronException {
    constructor() : super()
    constructor(msg: String?) : super(msg)
}