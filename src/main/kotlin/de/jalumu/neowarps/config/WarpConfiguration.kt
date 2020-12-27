package de.jalumu.neowarps.config

import org.bukkit.Location
import java.util.*

class WarpConfiguration(
    var warpName: String,
    var warpLocation: Location,
    var warpRepresentation: ItemRepresentation
){
    private var name: String = warpName
    private var location: Location = warpLocation
    private var representation: ItemRepresentation = warpRepresentation
}

class SharedWarpConfiguration(
    var warpWhitelist: MutableList<UUID>,
    var warpName: String,
    var warpLocation: Location,
    var warpRepresentation: ItemRepresentation
) {
    private var whitelist: MutableList<UUID> = warpWhitelist
    private var name: String = warpName
    private var location: Location = warpLocation
    private var representation: ItemRepresentation = warpRepresentation
}

class AccessibleWarpConfiguration(
    var warpName: String,
    var warpLocation: Location,
    var warpRepresentation: ItemRepresentation,
    var warpOwner: UUID
) {
    private var name: String = warpName
    private var location: Location = warpLocation
    private var representation: ItemRepresentation = warpRepresentation
    private var owner: UUID = warpOwner
}

class WarpUserData(
    var privateWarpsList: MutableMap<String, WarpConfiguration>,
    var sharedWarpsList: MutableMap<String, SharedWarpConfiguration>,
    var canAccessList: MutableMap<String, WarpConfiguration>
) {
    private  var privateWarps: MutableMap<String, WarpConfiguration> = privateWarpsList
    private var sharedWarps: MutableMap<String, SharedWarpConfiguration> = sharedWarpsList
    private var canAccess: MutableMap<String, WarpConfiguration> = canAccessList
}

class WarpPublicData {
    var warps: MutableMap<String, WarpConfiguration> = mutableMapOf()
}

class ItemRepresentation(var representationMaterial: String, var representationDisplayName: String, var representationLore: MutableList<String> = mutableListOf()) {
    private var material: String = representationMaterial
    var displayName: String = representationDisplayName
    private var lore: MutableList<String> = representationLore
}
