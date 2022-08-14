package de.lupu.bs.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class InventoryManager {

    public void setItems(Player p){

        p.getInventory().clear();

        // Navigator
        Item nav = new Item(Material.COMPASS);
        nav.setDisplayName("§c§lNavigator §7(rechtsklick)");
        p.getInventory().setItem(4, nav.build());

    }

    public void setBuildItems(Player p){
        p.getInventory().clear();

        p.getInventory().addItem(new ItemStack(Material.QUARTZ_BLOCK, 1));
        p.getInventory().addItem(new ItemStack(Material.STONE, 1));
        p.getInventory().addItem(new ItemStack(Material.GLASS, 1));
        p.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, 1));
        p.getInventory().addItem(new ItemStack(Material.OAK_WOOD, 1));
        p.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, 1));
        p.getInventory().addItem(new ItemStack(Material.WOODEN_AXE, 1));
        p.getInventory().addItem(new ItemStack(Material.FEATHER, 1));
        p.getInventory().addItem(new ItemStack(Material.FLINT, 1));


    }

    public Inventory getMapsSortInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §c§lKategorien");

        // Lobby
        Item lobby = new Item(Material.NETHER_STAR);
        lobby.setDisplayName("§7Kategorie §8• §bLobby");
        inv.setItem(10, lobby.build());

        // Bedwars
        Item bedwars = new Item(Material.RED_BED);
        bedwars.setDisplayName("§7Kategorie §8• §cBedwars");
        inv.setItem(20, bedwars.build());

        // Parkour
        Item parkour = new Item(Material.IRON_BOOTS);
        parkour.setDisplayName("§7Kategorie §8• §6Parkour");
        inv.setItem(12, parkour.build());

        // Survival
        Item survival = new Item(Material.GREEN_DYE);
        survival.setDisplayName("§7Kategorie §8• §aSurvival");
        inv.setItem(22, survival.build());

        // Others
        Item others = new Item(Material.BOOKSHELF);
        others.setDisplayName("§7Kategorie §8• §5Sonstige");
        inv.setItem(14, others.build());

        // All
        Item all = new Item(Material.BREWING_STAND);
        all.setDisplayName("§7Kategorie §8• §9Alle");
        inv.setItem(24, all.build());

        // Create Map
        Item create = new Item(Material.ANVIL);
        create.setDisplayName("§7» §9§lErstellen");
        create.setLore(Lore.create("§7Klick um eine Map zu erstellen."));
        inv.setItem(40, create.build());

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;
    }

    public Inventory getMapsLobbyInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7Kategorie §8• §bLobby");

        for(Map map : Map.getMapSortList(Gamemode.LOBBY)){
            Item item = new Item(Material.MAP);
            item.setDisplayName("§c§l" + map.getName());
            item.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                    , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate(), "§3Linksklick zum teleportieren"
                    , "§3Rechtsklick zum Löschen"));
            inv.addItem(item.build());
        }

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;

    }

    public Inventory getMapsBedwarsInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7Kategorie §8• §cBedwars");

        for(Map map : Map.getMapSortList(Gamemode.BEDWARS)){
            Item item = new Item(Material.MAP);
            item.setDisplayName("§c§l" + map.getName());
            item.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                    , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate(), "§3Linksklick zum teleportieren"
                    , "§3Rechtsklick zum Löschen"));
            inv.addItem(item.build());
        }

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;

    }

    public Inventory getMapsParkourInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7Kategorie §8• §6Parkour");

        for(Map map : Map.getMapSortList(Gamemode.PARKOUR)){
            Item item = new Item(Material.MAP);
            item.setDisplayName("§c§l" + map.getName());
            item.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                    , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate(), "§3Linksklick zum teleportieren"
                    , "§3Rechtsklick zum Löschen"));
            inv.addItem(item.build());
        }

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;

    }

    public Inventory getMapsSurvivalInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7Kategorie §8• §aSurvival");

        for(Map map : Map.getMapSortList(Gamemode.SURVIVAL)){
            Item item = new Item(Material.MAP);
            item.setDisplayName("§c§l" + map.getName());
            item.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                    , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate(), "§3Linksklick zum teleportieren"
                    , "§3Rechtsklick zum Löschen"));
            inv.addItem(item.build());
        }

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;

    }

    public Inventory getMapsOthersInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7Kategorie §8• §5Sonstige");

        for(Map map : Map.getMapSortList(Gamemode.OTHERS)){
            Item item = new Item(Material.MAP);
            item.setDisplayName("§c§l" + map.getName());
            item.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                    , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate(), "§3Linksklick zum teleportieren"
                    , "§3Rechtsklick zum Löschen"));
            inv.addItem(item.build());
        }

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;

    }

    public Inventory getMapsAllInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7Kategorie §8• §9Alle");

        File folder = new File("plugins//BauSystem//Maps");

        for(File file : folder.listFiles()){
            Map map = Map.fromFile(file);
            Item item = new Item(Material.MAP);
            item.setDisplayName("§c§l" + map.getName());
            item.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                    , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate(), "§3Linksklick zum teleportieren"
                    , "§3Rechtsklick zum Löschen"));
            inv.addItem(item.build());
        }

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;

    }

    public Inventory getMapSetupGamemodeTask(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, "§eSetze nun den Gamemode indem du ihn anklickst.");

        // Lobby
        Item lobby = new Item(Material.NETHER_STAR);
        lobby.setDisplayName("§bLobby");
        inv.setItem(1, lobby.build());

        // Bedwars
        Item bedwars = new Item(Material.RED_BED);
        bedwars.setDisplayName("§cBedwars");
        inv.setItem(2, bedwars.build());

        // Parkour
        Item parkour = new Item(Material.IRON_BOOTS);
        parkour.setDisplayName("§6Parkour");
        inv.setItem(3, parkour.build());

        // Survival
        Item survival = new Item(Material.GREEN_DYE);
        survival.setDisplayName("§aSurvival");
        inv.setItem(4, survival.build());

        // Others
        Item others = new Item(Material.BOOKSHELF);
        others.setDisplayName("§5Sonstiges");
        inv.setItem(5, others.build());

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;
    }

    public Inventory getMapSetupWorldTypeTask(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, "§eSetze nun den Welt Typ indem du ihn anklickst.");

        // Normal
        Item normal = new Item(Material.GRASS_BLOCK);
        normal.setDisplayName("§6Normal");
        inv.setItem(1, normal.build());

        // Amplified
        Item amplified = new Item(Material.SNOWBALL);
        amplified.setDisplayName("§6Amplified");
        inv.setItem(2, amplified.build());

        // Flat
        Item flat = new Item(Material.QUARTZ_SLAB);
        flat.setDisplayName("§6Flat");
        inv.setItem(3, flat.build());

        // End
        Item end = new Item(Material.END_CRYSTAL);
        end.setDisplayName("§6End");
        inv.setItem(4, end.build());

        // Nether
        Item nether = new Item(Material.NETHERRACK);
        nether.setDisplayName("§6Nether");
        inv.setItem(5, nether.build());

        // Large Biomes
        Item large = new Item(Material.OAK_SAPLING);
        large.setDisplayName("§6Large Biomes");
        inv.setItem(6, large.build());

        // Void
        Item voidItem = new Item(Material.BEDROCK);
        voidItem.setDisplayName("§6Void");
        inv.setItem(7, voidItem.build());

        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){
                Item item = new Item(Material.GRAY_STAINED_GLASS_PANE);
                item.setDisplayName(" ");
                inv.setItem(i, item.build());
            }
        }

        return inv;
    }

    public Inventory getMapDeleteConfirmInventory(Player p, Map map){
        Inventory inv = Bukkit.createInventory(null, 9*5, "§cMöchtest du die Map wirklich löschen?");

        // Map
        Item mapItem = new Item(Material.MAP);
        mapItem.setDisplayName("§c§l" + map.getName());
        mapItem.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate()));
        inv.setItem(13, mapItem.build());

        // Cancel
        Item cancel = new Item(Material.RED_STAINED_GLASS_PANE);
        cancel.setDisplayName("§c§lAbbrechen");
        inv.setItem(29, cancel.build());

        // Confirm
        Item confirm = new Item(Material.LIME_STAINED_GLASS_PANE);
        confirm.setDisplayName("§a§lBestätigen");
        confirm.setLore(Lore.create("§7Die Map wird entgültig gelöscht§c!!!"));
        inv.setItem(33, confirm.build());

        return inv;

    }

    public Inventory getMapOptionsInventory(Player p, Map map){
        Inventory inv = Bukkit.createInventory(null, 9*5, "§c§l" + map.getName());

        // Map
        Item mapItem = new Item(Material.MAP);
        mapItem.setDisplayName("§c§l" + map.getName());
        mapItem.setLore(Lore.create("§aBuilder: §7" + map.getBuilderName(), "§aWorld: §7" + map.getWorldName(), "§aGamemode: §7" + map.getGamemode().toString()
                , "§aDesign: §7" + map.getDesign(), "§aDescription: §7" + map.getDescription(), "§aDate: §7" + map.getDate()));
        inv.setItem(13, mapItem.build());



        return inv;

    }

}
