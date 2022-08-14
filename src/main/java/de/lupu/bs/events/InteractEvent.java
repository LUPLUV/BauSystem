package de.lupu.bs.events;

import de.lupu.bs.BauSystem;
import de.lupu.bs.commands.BuildCmd;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();

        if(item != null){
            if(item.getType() != Material.AIR){
                Material type = item.getType();
                if(!BuildCmd.canBuild.contains(p)) {
                    if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
                        if (type == Material.COMPASS){
                            p.openInventory(BauSystem.getInventoryManager().getMapsSortInventory(p));
                        }
                    }
                }
            }
        }
    }

}
