package de.jalumu.neowarps.config

import org.bukkit.Location
import java.util.*

class WarpConfiguration(
    var warpName: String,
    var warpLocation: Location,
    var warpRepresentation: ItemRepresentation
){
    var name: String = warpName
    var location: Location = warpLocation
    var representation: ItemRepresentation = warpRepresentation
}

class SharedWarpConfiguration(
    var warpWhitelist: MutableList<UUID>,
    var warpName: String,
    var warpLocation: Location,
    var warpRepresentation: ItemRepresentation
) {
    var whitelist: MutableList<UUID> = warpWhitelist
    var name: String = warpName
    var location: Location = warpLocation
    var representation: ItemRepresentation = warpRepresentation
}

class AccessibleWarpConfiguration(
    var warpName: String,
    var warpLocation: Location,
    var warpRepresentation: ItemRepresentation,
    var warpOwner: UUID
) {
    var name: String = warpName
    var location: Location = warpLocation
    var representation: ItemRepresentation = warpRepresentation
    var owner: UUID = warpOwner
}

class WarpUserData(
    var privateWarpsList: MutableList<WarpConfiguration>,
    var sharedWarpsList: MutableList<SharedWarpConfiguration>,
    var canAccessList: MutableList<WarpConfiguration>
) {
    var privateWarps: MutableList<WarpConfiguration> = privateWarpsList
    var sharedWarps: MutableList<SharedWarpConfiguration> = sharedWarpsList
    var canAccess: MutableList<WarpConfiguration> = canAccessList
}

class WarpPublicData {
    var warps: MutableList<String> = mutableListOf()
}

class ItemRepresentation(var material: String, var displayName: String, var lore: MutableList<String> = mutableListOf())
