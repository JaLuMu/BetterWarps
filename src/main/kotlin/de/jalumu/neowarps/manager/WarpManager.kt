package de.jalumu.neowarps.manager

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.jalumu.neowarps.NeoWarps
import de.jalumu.neowarps.config.WarpPublicData
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class WarpManager(val plugin: NeoWarps) {

    val publicWarpFile: File = File(plugin.dataFolder, "public_warps.json")
    var warpPublicData: WarpPublicData?

    init {

        if (!publicWarpFile.exists()) {
            plugin.dataFolder.mkdirs()
            publicWarpFile.createNewFile()
            val writer = FileWriter(publicWarpFile)
            writer.write(GsonBuilder().setPrettyPrinting().create().toJson(WarpPublicData()))
            writer.flush()
            writer.close()
        }

        this.warpPublicData = Gson().fromJson(FileReader(publicWarpFile), WarpPublicData::class.java)

    }

}