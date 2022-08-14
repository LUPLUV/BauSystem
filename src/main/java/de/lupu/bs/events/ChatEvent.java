package de.lupu.bs.events;

import de.lupu.bs.BauSystem;
import de.lupu.bs.utils.Map;
import de.lupu.bs.utils.MapTask;
import de.lupu.bs.utils.Strings;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent e){
        Player p = e.getPlayer();
        String msg = e.getMessage();

        if(BauSystem.getUtil().mapSetups.containsKey(p)){
            Map map = BauSystem.getUtil().mapSetups.get(p);
            e.setCancelled(true);
            if(map.getMapTask() == MapTask.NAME){
                if(!Map.existsName(msg)) {
                    map.setName(msg);
                    p.sendMessage(Strings.prefix + "Du hast den Map Namen auf '§c" + msg + "§7' gesetzt.");
                    p.sendMessage(Strings.prefix + "§eSetze nun den Builder Namen indem du ihn in den Chat schreibst.");
                    map.setMapTask(MapTask.BUILDER_NAME);
                }else{
                    p.sendMessage(Strings.prefix + "§cDieser Map Name existiert bereits!");
                    p.sendMessage(Strings.prefix + "§eSetze als erstes den Map Namen, indem du ihn in den Chat schreibst.");
                }
            }else if(map.getMapTask() == MapTask.BUILDER_NAME){
                map.setBuilderName(msg);
                p.sendMessage(Strings.prefix + "Du hast den Builder Namen auf '§c" + msg + "§7' gesetzt.");
                map.setMapTask(MapTask.GAMEMODE);
                p.openInventory(BauSystem.getInventoryManager().getMapSetupGamemodeTask(p));
            }else if(map.getMapTask() == MapTask.DESIGN){
                map.setDesign(msg);
                p.sendMessage(Strings.prefix + "Du hast das Map Design auf '§c" + msg + "§7' gesetzt.");
                p.sendMessage(Strings.prefix + "§eSetze nun die Map Beschreibung indem du ihn in den Chat schreibst.");
                map.setMapTask(MapTask.DESCRIPTION);
            }else if(map.getMapTask() == MapTask.DESCRIPTION){
                map.setDescription(msg);
                p.sendMessage(Strings.prefix + "Du hast die Map Beschreibung auf '§c" + msg + "§7' gesetzt.");
                p.sendMessage(Strings.prefix + "§eSetze nun den Welt Namen indem du ihn in den Chat schreibst.");
                map.setMapTask(MapTask.WORLD);
            }else if(map.getMapTask() == MapTask.WORLD){
                map.setWorldName(msg);
                p.sendMessage(Strings.prefix + "Du hast den Welt Namen auf '§c" + msg + "§7' gesetzt.");
                map.setMapTask(MapTask.WORLD_TYPE);
                p.openInventory(BauSystem.getInventoryManager().getMapSetupWorldTypeTask(p));
            }
        }

    }

}
