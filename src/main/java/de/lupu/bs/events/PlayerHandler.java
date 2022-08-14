package de.lupu.bs.events;

import de.lupu.bs.BauSystem;
import de.lupu.bs.commands.BuildCmd;
import de.lupu.bs.utils.MapTask;
import de.lupu.bs.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        e.setJoinMessage("§7[§a»§7] §6" + p.getName());

        p.setGameMode(GameMode.CREATIVE);
        p.setExp(0);
        p.setLevel(0);
        p.setAllowFlight(true);
        p.setHealth(20);
        p.setFoodLevel(20);
        BauSystem.getInventoryManager().setItems(p);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage("§7[§c«§7] §6" + p.getName());

        if(BuildCmd.canBuild.contains(p)) BuildCmd.canBuild.remove(p);
        if(BauSystem.getUtil().mapSetups.containsKey(p)) BauSystem.getUtil().mapSetups.remove(p);

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();

        if(!BuildCmd.canBuild.contains(p)){
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();

        if(!BuildCmd.canBuild.contains(p)){
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();

        if(!BuildCmd.canBuild.contains(p)){
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e){
        Player p = e.getPlayer();

        if(!BuildCmd.canBuild.contains(p)){
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){

        if(e.getEntityType() == EntityType.PLAYER) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onDamageEx(EntityDamageByEntityEvent e){
        if(e.getDamager().getType() == EntityType.PLAYER){
            Player p = (Player) e.getDamager();
            if(!BuildCmd.canBuild.contains(p)){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        if(p.getOpenInventory().getTitle().equalsIgnoreCase("§eSetze nun den Gamemode indem du ihn anklickst.")){
            if(BauSystem.getUtil().mapSetups.get(p).getMapTask() == MapTask.GAMEMODE) {
                BauSystem.getUtil().mapSetups.remove(p);
                p.sendMessage(Strings.prefix + "Das Setup wurde abgebrochen!");
            }
        }else if(p.getOpenInventory().getTitle().equalsIgnoreCase("§eSetze nun den Welt Typ indem du ihn anklickst.")){
            if(BauSystem.getUtil().mapSetups.get(p).getMapTask() == MapTask.WORLD_TYPE) {
                BauSystem.getUtil().mapSetups.remove(p);
                p.sendMessage(Strings.prefix + "Das Setup wurde abgebrochen!");
            }
        }
    }

    @EventHandler
    public void onCreative(InventoryCreativeEvent e){
        if(!BuildCmd.canBuild.contains((Player) e.getWhoClicked())){
            e.setCancelled(true);
        }
    }

}
