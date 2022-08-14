package de.lupu.bs.utils;

import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Util {

    public String getPrefix(Player p){
        return "coming soon";
    }

    public String getGroup(Player p){
        return "coming soon";
    }

    public java.util.Map<Player, Map> mapSetups = new HashMap<>();

    public String getFormattedDate(){
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        return format.format(date);
    }


}
