package de.lupu.bs.utils;

import com.onarandombox.MultiverseCore.api.MVWorldManager;
import de.lupu.bs.BauSystem;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    public static boolean existsName(String name){
        for(Map map : getMapList()){
            if(map.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public static Map fromFile(File file){
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Map map = new Map();
        map.setName(cfg.getString("Name"));
        map.setBuilderName(cfg.getString("BuilderName"));
        map.setWorldName(cfg.getString("WorldName"));
        map.setGamemode(Gamemode.valueOf(cfg.getString("Gamemode")));
        map.setDesign(cfg.getString("Design"));
        map.setDescription(cfg.getString("Description"));
        map.setDate(cfg.getString("Date"));
        return map;
    }

    public static Map getMap(String name){
        File file = new File("plugins//BauSystem//Maps//" + name + ".yml");
        return fromFile(file);
    }

    public static List<Map> getMapList(){
        File folder = new File("plugins//BauSystem//Maps");
        List<Map> mapList = new ArrayList<>();

        for(File file : folder.listFiles()){
            Map map = Map.fromFile(file);
            mapList.add(map);
        }

        return mapList;
    }

    public static List<Map> getMapSortList(Gamemode gamemode){
        List<Map> sortedList = new ArrayList<>();
        for(Map map : getMapList()){
            if(map.getGamemode() == gamemode){
                sortedList.add(map);
            }
        }
        return sortedList;
    }

    String name;
    String builderName;
    String worldName;
    Gamemode gamemode;
    String design;
    String description;
    String date;
    WorldType worldType;
    MapTask mapTask;
    boolean isInSetup;

    public Map() {
    }

    public Map(String name) {
        this.name = name;
    }

    public Map(String name, String builderName, String worldName, Gamemode gamemode, String design, String description, String date) {
        this.name = name;
        this.builderName = builderName;
        this.worldName = worldName;
        this.gamemode = gamemode;
        this.design = design;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilderName() {
        return builderName;
    }

    public void setBuilderName(String builderName) {
        this.builderName = builderName;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public Gamemode getGamemode() {
        return gamemode;
    }

    public void setGamemode(Gamemode gamemode) {
        this.gamemode = gamemode;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MapTask getMapTask() {
        return mapTask;
    }

    public void setMapTask(MapTask mapTask) {
        this.mapTask = mapTask;
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public void setWorldType(WorldType worldType) {
        this.worldType = worldType;
    }

    public boolean isInSetup() {
        return isInSetup;
    }

    public void setInSetup(boolean inSetup) {
        isInSetup = inSetup;
    }

    public File getFile(){
        return new File("plugins//BauSystem//Maps//" + name +".yml");
    }

    public boolean exists(){
        return getFile().exists();
    }

    public void save() throws IOException {
        File file = getFile();
        if(exists()){
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            cfg.set("Name", this.name);
            cfg.set("BuilderName", this.builderName);
            cfg.set("WorldName", this.worldName);
            cfg.set("Gamemode", this.gamemode.toString());
            cfg.set("Design", this.design);
            cfg.set("Description", this.description);
            cfg.set("Date", this.date);
            cfg.save(file);
        }
    }

    public void createMap() throws IOException {
        if(getFile().exists()){
            getFile().delete();
        }
        getFile().createNewFile();
    }

    public void deleteMap(){
        if(getFile().exists()){
            getFile().delete();
        }
    }

    public void createWorld(){

        MVWorldManager api = BauSystem.getCore().getMVWorldManager();
        if(worldType == WorldType.NORMAL){
            api.addWorld(worldName, World.Environment.NORMAL, null, org.bukkit.WorldType.NORMAL, true, null);
        }else if(worldType == WorldType.NETHER){
            api.addWorld(worldName, World.Environment.NETHER, null, org.bukkit.WorldType.NORMAL, true, null);
        }else if(worldType == WorldType.END){
            api.addWorld(worldName, World.Environment.THE_END, null, org.bukkit.WorldType.NORMAL, true, null);
        }else if(worldType == WorldType.FLAT){
            api.addWorld(worldName, World.Environment.NORMAL, null, org.bukkit.WorldType.FLAT, true, null);
        }else if(worldType == WorldType.AMPLIFIED){
            api.addWorld(worldName, World.Environment.NORMAL, null, org.bukkit.WorldType.AMPLIFIED, true, null);
        }else if(worldType == WorldType.LARGE_BIOMES){
            api.addWorld(worldName, World.Environment.NORMAL, null, org.bukkit.WorldType.LARGE_BIOMES, true, null);
        }else if(worldType == WorldType.VOID){
            api.addWorld(worldName, World.Environment.NORMAL, null, org.bukkit.WorldType.NORMAL, true, "VoidGen");
        }
        api.loadWorld(worldName);
        World w = Bukkit.getWorld(worldName);
        assert w != null;
        w.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        w.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        w.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        w.save();
    }

}
