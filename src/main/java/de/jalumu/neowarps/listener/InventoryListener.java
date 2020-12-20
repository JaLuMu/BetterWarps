package de.jalumu.neowarps.listener;

import de.jalumu.neowarps.util.Transmission;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        String title = event.getView().getTitle();

        if (title.contains(new Transmission().appendPluginPrefix().getTransmissionContent())){
            event.setCancelled(true);
            String[] strings = title.split("\\| ");
        }
    }

}
