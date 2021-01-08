package de.jalumu.neowarps.config

import org.bukkit.Location
import org.bukkit.Material
import java.io.Serializable
import java.util.*
import kotlin.collections.HashMap

class WarpConfiguration(
    private var warpName: String,
    private var warpLocation: Location,
    private var warpRepresentation: ItemRepresentation
){
    var name: String = warpName
    var location: Location = warpLocation
    var representation: ItemRepresentation = warpRepresentation
}

class SharedWarpConfiguration(
    private var warpWhitelist: MutableList<UUID>,
    private var warpName: String,
    private var warpLocation: Location,
    private var warpRepresentation: ItemRepresentation
) {
    var whitelist: MutableList<UUID> = warpWhitelist
    var name: String = warpName
    var location: Location = warpLocation
    var representation: ItemRepresentation = warpRepresentation
}

class AccessibleWarpConfiguration(
    private var warpName: String,
    private var warpLocation: Location,
    private var warpRepresentation: ItemRepresentation,
    private var warpOwner: UUID
) {
    var name: String = warpName
    var location: Location = warpLocation
    var representation: ItemRepresentation = warpRepresentation
    var owner: UUID = warpOwner
}

class WarpUserData(
    private var privateWarpsList: MutableMap<String, WarpConfiguration>,
    private var sharedWarpsList: MutableMap<String, SharedWarpConfiguration>,
    private var canAccessList: MutableMap<String, WarpConfiguration>
) {
    var privateWarps: MutableMap<String, WarpConfiguration> = privateWarpsList
    var sharedWarps: MutableMap<String, SharedWarpConfiguration> = sharedWarpsList
    var canAccess: MutableMap<String, WarpConfiguration> = canAccessList
}

class WarpPublicData : Serializable{
    var warps: MutableMap<String, WarpConfiguration> = HashMap<String, WarpConfiguration>()
}

class ItemRepresentation(var representationMaterial: Material, var representationDisplayName: String, var representationLore: MutableList<String> = mutableListOf()) {
    private var material: Material =  representationMaterial
    var displayName: String = representationDisplayName
    private var lore: MutableList<String> = representationLore
}
