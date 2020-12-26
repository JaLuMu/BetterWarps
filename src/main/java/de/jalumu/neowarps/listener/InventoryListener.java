package de.jalumu.neowarps.listener;

import de.jalumu.neowarps.gui.WarpGui;
import de.jalumu.neowarps.util.Transmission;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class InventoryListener implements Listener {

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        Player player = (Player) event.getView().getPlayer();

        if (title.contains(new Transmission().appendPluginPrefix().getTransmissionContent())){
            event.setCancelled(true);
            String[] strings = title.split("\\| ");

            if (strings[1].contains("Warp Menu")){
                switch (event.getCurrentItem().getItemMeta().getDisplayName()){
                    case "   ":
                        player.playSound(player.getLocation(), Sound.ENTITY_CAT_STRAY_AMBIENT,1,1);
                        break;
                    case "Private Warps":
                        event.getView().close();
                        WarpGui.openWarpGui(player);
                        break;
                }
            }
        }
    }

}
