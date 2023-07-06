package com.possiblepanda.utility;

import com.possiblepanda.components.PlayerStat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerUtility {
    private static Map<String, PlayerStat> playerStat = new HashMap<>();

    public static PlayerStat getPlayerStat(Player p) {
        if(!playerStat.containsKey(p.getUniqueId())) {
            PlayerStat s = new PlayerStat();
            playerStat.put(p.getUniqueId().toString(), s);
            return s;
        }
        return playerStat.get(p.getUniqueId().toString());
    }

    public static void setPlayerStat(Player p, PlayerStat stats){
        playerStat.put(p.getUniqueId().toString(), stats);
    }

    public static String getFolderPath(Player p) {
        return Bukkit.
    }
}
