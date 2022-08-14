package de.lupu.bs.utils;

import de.lupu.bs.BauSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardManager {

    public List<Player> activatedScoreboard = new ArrayList<>();

    public void update(Player p){
        if(p.getScoreboard() == null){
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective obj = board.registerNewObjective("abcd", "abcd");
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);
            obj.setDisplayName("§b§lEZTORIA §cBAUSERVER");
            obj.getScore(" ").setScore(9);
            obj.getScore("§aRang§8:").setScore(8);
            obj.getScore("§c").setScore(7);
            obj.getScore("  ").setScore(6);
            obj.getScore("§aWelt§8:").setScore(5);
            obj.getScore("§e").setScore(4);
            obj.getScore("   ").setScore(3);
            obj.getScore("§aOnline§8:").setScore(2);
            obj.getScore("§b").setScore(1);
            obj.getScore("    ").setScore(0);
            Team rank = board.registerNewTeam("rank");
            Team world = board.registerNewTeam("world");
            Team online = board.registerNewTeam("online");
            rank.addEntry("§c");
            world.addEntry("§e");
            online.addEntry("§b");
            rank.setPrefix(BauSystem.getUtil().getPrefix(p) + p.getName());
            world.setPrefix("§e" + p.getLocation().getWorld().getName());
            online.setPrefix("§b" + Bukkit.getOnlinePlayers().size() + "§8/§c" + Bukkit.getMaxPlayers());
        }else{
            Scoreboard board = p.getScoreboard();
            Team rank = board.getTeam("rank");
            Team world = board.getTeam("world");
            Team online = board.getTeam("online");
            rank.setPrefix(BauSystem.getUtil().getPrefix(p) + p.getName());
            world.setPrefix("§e" + p.getLocation().getWorld().getName());
            online.setPrefix("§b" + Bukkit.getOnlinePlayers().size() + "§8/§c" + Bukkit.getMaxPlayers());
        }
    }

    public void startScoreboardTask(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BauSystem.getPlugin(), new Runnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if(activatedScoreboard.contains(player)){
                        update(player);
                    }
                }
            }
        }, 0, 20*2);
    }

}
