package org.reuac.itemframelorekeeper;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.inventory.ItemStack;


public class MainListener implements Listener {
    static ItemStack mainItem;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onHangingBreakEvent(HangingBreakEvent event){
        if (event.getEntity() instanceof ItemFrame){
            ItemFrame event_itemFrame = (ItemFrame) event.getEntity();
            if (!event_itemFrame.isVisible()){
                event.setCancelled(true);
                event_itemFrame.remove();
                event_itemFrame.getWorld().dropItemNaturally(event_itemFrame.getLocation(), mainItem);
                if (event_itemFrame.getItem().getType() != Material.AIR){
                    event_itemFrame.getWorld().dropItemNaturally(event_itemFrame.getLocation(), event_itemFrame.getItem());
                }
            }
        }
    }
}
