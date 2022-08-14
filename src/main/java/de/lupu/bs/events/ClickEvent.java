package de.lupu.bs.events;

import com.onarandombox.MultiverseCore.api.MVWorldManager;
import de.lupu.bs.BauSystem;
import de.lupu.bs.commands.BuildCmd;
import de.lupu.bs.utils.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        String title = e.getView().getTitle();
        Inventory inv = e.getClickedInventory();
        ItemStack item = e.getCurrentItem();

        if(item != null){
            if(item.getType() != Material.AIR){
                Material type = item.getType();
                if(title.equalsIgnoreCase("§7» §c§lKategorien")){
                    e.setCancelled(true);
                    if(type == Material.RED_BED){
                        p.openInventory(BauSystem.getInventoryManager().getMapsBedwarsInventory(p));
                    }else if(type == Material.NETHER_STAR){
                        p.openInventory(BauSystem.getInventoryManager().getMapsLobbyInventory(p));
                    }else if(type == Material.BREWING_STAND){
                        p.openInventory(BauSystem.getInventoryManager().getMapsAllInventory(p));
                    }else if(type == Material.IRON_BOOTS){
                        p.openInventory(BauSystem.getInventoryManager().getMapsParkourInventory(p));
                    }else if(type == Material.GREEN_DYE){
                        p.openInventory(BauSystem.getInventoryManager().getMapsSurvivalInventory(p));
                    }else if(type == Material.BOOKSHELF){
                        p.openInventory(BauSystem.getInventoryManager().getMapsOthersInventory(p));
                    }else if(type == Material.ANVIL){
                        if(p.hasPermission("system.maps.create")){
                            if(!BauSystem.getUtil().mapSetups.containsKey(p)) {
                                p.closeInventory();
                                Map map = new Map();
                                map.setInSetup(true);
                                map.setMapTask(MapTask.NAME);
                                BauSystem.getUtil().mapSetups.put(p, map);
                                p.sendMessage(Strings.prefix + "§eSetze als erstes den Map Namen, indem du ihn in den Chat schreibst.");
                            }else{
                                p.sendMessage(Strings.prefix + "Du erstellst gerade schon eine Map!");
                            }
                        }else
                            p.sendMessage(Strings.noPerms);
                    }
                }else if(title.equalsIgnoreCase("§7Kategorie §8• §bLobby")){
                    e.setCancelled(true);
                    if(type == Material.MAP){
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            Map map = Map.getMap(item.getItemMeta().getDisplayName().replace("§c§l", ""));
                            p.openInventory(BauSystem.getInventoryManager().getMapDeleteConfirmInventory(p, map));
                        }else {
                            p.performCommand("mvtp " + item.getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                            p.closeInventory();
                        }
                    }
                }else if(title.equalsIgnoreCase("§7Kategorie §8• §cBedwars")){
                    e.setCancelled(true);
                    if(type == Material.MAP){
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            Map map = Map.getMap(item.getItemMeta().getDisplayName().replace("§c§l", ""));
                            p.openInventory(BauSystem.getInventoryManager().getMapDeleteConfirmInventory(p, map));
                        }else {
                            p.performCommand("mvtp " + item.getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                            p.closeInventory();
                        }
                    }
                }else if(title.equalsIgnoreCase("§7Kategorie §8• §aSurvival")){
                    e.setCancelled(true);
                    if(type == Material.MAP){
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            Map map = Map.getMap(item.getItemMeta().getDisplayName().replace("§c§l", ""));
                            p.openInventory(BauSystem.getInventoryManager().getMapDeleteConfirmInventory(p, map));
                        }else {
                            p.performCommand("mvtp " + item.getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                            p.closeInventory();
                        }
                    }
                }else if(title.equalsIgnoreCase("§7Kategorie §8• §9Alle")){
                    e.setCancelled(true);
                    if(type == Material.MAP){
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            Map map = Map.getMap(item.getItemMeta().getDisplayName().replace("§c§l", ""));
                            p.openInventory(BauSystem.getInventoryManager().getMapDeleteConfirmInventory(p, map));
                        }else {
                            p.performCommand("mvtp " + item.getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                            p.closeInventory();
                        }
                    }
                }else if(title.equalsIgnoreCase("§7Kategorie §8• §6Parkour")){
                    e.setCancelled(true);
                    if(type == Material.MAP){
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            Map map = Map.getMap(item.getItemMeta().getDisplayName().replace("§c§l", ""));
                            p.openInventory(BauSystem.getInventoryManager().getMapDeleteConfirmInventory(p, map));
                        }else {
                            p.performCommand("mvtp " + item.getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                            p.closeInventory();
                        }
                    }
                }else if(title.equalsIgnoreCase("§7Kategorie §8• §5Sonstige")){
                    e.setCancelled(true);
                    if(type == Material.MAP){
                        if(e.getAction() == InventoryAction.PICKUP_HALF){
                            Map map = Map.getMap(item.getItemMeta().getDisplayName().replace("§c§l", ""));
                            p.openInventory(BauSystem.getInventoryManager().getMapDeleteConfirmInventory(p, map));
                        }else {
                            p.performCommand("mvtp " + item.getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                            p.closeInventory();
                        }
                    }
                }else if(title.equalsIgnoreCase("§eSetze nun den Gamemode indem du ihn anklickst.")){
                    e.setCancelled(true);
                    Map map = BauSystem.getUtil().mapSetups.get(p);
                    if(item.getType() == Material.NETHER_STAR) map.setGamemode(Gamemode.LOBBY);
                    if(item.getType() == Material.RED_BED) map.setGamemode(Gamemode.BEDWARS);
                    if(item.getType() == Material.IRON_BOOTS) map.setGamemode(Gamemode.PARKOUR);
                    if(item.getType() == Material.GREEN_DYE) map.setGamemode(Gamemode.SURVIVAL);
                    if(item.getType() == Material.BOOKSHELF) map.setGamemode(Gamemode.OTHERS);
                    p.sendMessage(Strings.prefix + "Du hast den Gamemode auf '§c" + map.getGamemode().toString() + "§7' gesetzt.");
                    map.setMapTask(MapTask.DESIGN);
                    p.sendMessage(Strings.prefix + "§eSetze nun den Design Namen indem du ihn in den Chat schreibst.");
                    p.closeInventory();
                }else if(title.equalsIgnoreCase("§eSetze nun den Welt Typ indem du ihn anklickst.")){
                    e.setCancelled(true);
                    Map map = BauSystem.getUtil().mapSetups.get(p);
                    if(item.getType() == Material.NETHERRACK) map.setWorldType(WorldType.NETHER);
                    if(item.getType() == Material.SNOWBALL) map.setWorldType(WorldType.AMPLIFIED);
                    if(item.getType() == Material.END_CRYSTAL) map.setWorldType(WorldType.END);
                    if(item.getType() == Material.QUARTZ_SLAB) map.setWorldType(WorldType.FLAT);
                    if(item.getType() == Material.OAK_SAPLING) map.setWorldType(WorldType.LARGE_BIOMES);
                    if(item.getType() == Material.GRASS_BLOCK) map.setWorldType(WorldType.NORMAL);
                    if(item.getType() == Material.BEDROCK) map.setWorldType(WorldType.VOID);

                    p.closeInventory();
                    p.sendMessage(Strings.prefix + "Du hast den Welt Typ auf '§c" + map.getWorldType().toString() + "§7' gesetzt.");
                    p.sendMessage(Strings.prefix + "§eDu bist mit dem erstellen fertig. Deine Map wird in kürze " +
                            "für dich verfügbar sein und im Navigator unter '" + map.getGamemode().toString() + "' hinzugefügt.");
                    map.setDate(BauSystem.getUtil().getFormattedDate());
                    map.setInSetup(false);
                    map.setMapTask(null);
                    map.createWorld();
                    try {
                        map.createMap();
                        map.save();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    BauSystem.getUtil().mapSetups.remove(p);


                }else if(title.equalsIgnoreCase("§cMöchtest du die Map wirklich löschen?")){
                    e.setCancelled(true);
                    Map map = Map.getMap(inv.getItem(13).getItemMeta().getDisplayName().replace("§c§l", ""));
                    if(item.getType() == Material.RED_STAINED_GLASS_PANE) p.closeInventory();
                    if(item.getType() == Material.LIME_STAINED_GLASS_PANE){
                        p.closeInventory();
                        p.sendMessage(Strings.prefix + "Die Map wird gelöscht...");
                        map.deleteMap();
                        MVWorldManager api = BauSystem.getCore().getMVWorldManager();
                        api.deleteWorld(inv.getItem(13).getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                        api.removeWorldFromConfig(inv.getItem(13).getItemMeta().getLore().get(1).replace("§aWorld: §7", ""));
                        p.sendMessage(Strings.prefix + "§aOperation erflolgreich :D");
                    }
                }else if(!BuildCmd.canBuild.contains(p)){
                    e.setCancelled(true);
                }
            }
        }

    }

}
