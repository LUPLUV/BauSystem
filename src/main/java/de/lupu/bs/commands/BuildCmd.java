package de.lupu.bs.commands;

import de.lupu.bs.BauSystem;
import de.lupu.bs.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BuildCmd implements CommandExecutor {

    public static List<Player> canBuild = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if(!p.hasPermission("system.build")){
                p.sendMessage(Strings.noPerms);
            }else
                if(strings.length == 0) {
                    if(canBuild.contains(p)){
                        canBuild.remove(p);
                        p.sendMessage(Strings.prefix + "Du kannst nun nicht mehr bauen!");
                        p.setGameMode(GameMode.CREATIVE);
                        BauSystem.getInventoryManager().setItems(p);
                    }else if(!canBuild.contains(p)){
                        canBuild.add(p);
                        BauSystem.getInventoryManager().setBuildItems(p);
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Strings.prefix + "Du kannst nun bauen!");
                    }
                }else if(strings.length == 1){
                    Player t = Bukkit.getPlayer(strings[0]);
                    if(t != null){
                        if(canBuild.contains(t)){
                            canBuild.remove(t);
                            t.setGameMode(GameMode.CREATIVE);
                            BauSystem.getInventoryManager().setItems(t);
                            p.sendMessage(Strings.prefix + t.getName() + " kann nun nicht mehr bauen!");
                            t.sendMessage(Strings.prefix + "Du kannst nun nicht mehr bauen!");
                        }else if(!canBuild.contains(t)){
                            canBuild.add(t);
                            BauSystem.getInventoryManager().setBuildItems(t);
                            t.setGameMode(GameMode.CREATIVE);
                            t.sendMessage(Strings.prefix + t.getName() + " kann nun bauen!");
                            t.sendMessage(Strings.prefix + "Du kannst nun bauen");
                        }
                    }else
                        p.sendMessage(Strings.playerNotFound);
                }else
                    p.sendMessage(Strings.prefix + "Bitte benutze /build [spieler]");
        }

        return false;
    }
}
