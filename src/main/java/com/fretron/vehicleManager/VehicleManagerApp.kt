package com.fretron.vehicleManager

import com.fretron.vehicleManager.di.component.DaggerVehicleAppComponent

fun main() {

    val appComponent = DaggerVehicleAppComponent.builder().build()
    val httpServer = appComponent.server()
    httpServer.start()

}