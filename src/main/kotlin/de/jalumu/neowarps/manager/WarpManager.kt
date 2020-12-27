package de.jalumu.neowarps.manager

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.jalumu.neowarps.NeoWarps
import de.jalumu.neowarps.config.SharedWarpConfiguration
import de.jalumu.neowarps.config.WarpConfiguration
import de.jalumu.neowarps.config.WarpPublicData
import de.jalumu.neowarps.config.WarpUserData
import de.jalumu.neowarps.exception.WarpNotExistsException
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.*

class WarpManager(val plugin: NeoWarps) {

    private val publicWarpFile: File = File("${plugin.dataFolder.path}/storage", "public_warps.json")
    var publicWarpData: WarpPublicData
    val GSON: Gson = GsonBuilder().serializeNulls().setPrettyPrinting().create()

    init {
        
        if (!publicWarpFile.exists()) {
            plugin.dataFolder.mkdirs()
            publicWarpFile.createNewFile()
            val writer: FileWriter = FileWriter(publicWarpFile)
            writer.write(GSON.toJson(WarpPublicData()))
            writer.flush()
            writer.close()
        }
        this.publicWarpData = GSON.fromJson(FileReader(publicWarpFile), WarpPublicData::class.java)
    }

    fun getWarps(owner: UUID): WarpUserData {
        val storageFile: File = File("${plugin.dataFolder.name}/storage", "$owner")
        if (storageFile.exists()) {
            return Gson().fromJson(FileReader(storageFile), WarpUserData::class.java)
        }else {
            val warpUserData: WarpUserData = WarpUserData(mutableMapOf(), mutableMapOf(), mutableMapOf())
            storageFile.createNewFile()
            val writer: FileWriter = FileWriter(storageFile)
            writer.write(GSON.toJson(warpUserData))
            return warpUserData
        }
    }

    fun updatePublicWarpList() {
        val writer: FileWriter = FileWriter(publicWarpFile)
        writer.write(GSON.toJson(publicWarpFile))
        writer.flush()
        writer.close()
    }

    fun addToSharedWarp(warp: SharedWarpConfiguration, player: UUID): SharedWarpConfiguration {
        val cfg: SharedWarpConfiguration = warp
        if (!cfg.whitelist.contains(player)) {
            cfg.whitelist.add(player)
        }
        val playerData: WarpUserData = getWarps(player)
        playerData.canAccess.put(warp.name, WarpConfiguration(warp.name, warp.location, warp.representation))
        update(player, playerData)
        return cfg
    }

    fun shareWarp(warpName: String, owner: UUID, whitelist: MutableList<UUID>): SharedWarpConfiguration {
        val data: WarpUserData = getWarps(owner)
        if (data.privateWarps.keys.contains(warpName)) {
            val warp: WarpConfiguration? = data.privateWarps.get(warpName)
            val sharedWarp: SharedWarpConfiguration = SharedWarpConfiguration(whitelist, warp!!.name, warp.location, warp.representation)
            data.sharedWarps.put(sharedWarp.name, sharedWarp)
            update(owner, data)
            return sharedWarp
        }else {
            throw WarpNotExistsException("The Warp $warpName from Player $owner does not exists")
        }
    }

    fun update(owner: UUID, warpUserData: WarpUserData) {
        val storageFile: File = File("${plugin.dataFolder.path}/storage", "$owner")
        if (!storageFile.exists()) {
            storageFile.createNewFile()
        }
        val writer: FileWriter = FileWriter(storageFile)
        writer.write(GSON.toJson(warpUserData))
        writer.flush()
        writer.close()
    }

}