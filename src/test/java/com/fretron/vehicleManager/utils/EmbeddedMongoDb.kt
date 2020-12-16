package com.fretron.vehicleManager.utils

import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodProcess
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder
import de.flapdoodle.embed.mongo.config.Net
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network
import java.io.IOException

class EmbeddedMongoDb {
    var port: Int
        private set
    private var process: MongodProcess? = null

    constructor() {
        port = 27017
    }

    constructor(port: Int) {
        this.port = port
    }

    @Throws(IOException::class)
    fun start(port: Int) {
        this.port = port
        start()
    }

    @Throws(IOException::class)
    fun start() {
        val starter: MongodStarter = MongodStarter.getDefaultInstance()
        val executable: MongodExecutable = starter.prepare(
            MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(Net(port, Network.localhostIsIPv6()))
                .build()
        )
        process = executable.start()
    }

    fun stop() {
        process?.stop()
    }
}