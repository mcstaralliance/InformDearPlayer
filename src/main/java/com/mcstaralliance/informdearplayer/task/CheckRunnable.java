package com.mcstaralliance.informdearplayer.task;

import com.mcstaralliance.informdearplayer.InformDearPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class CheckRunnable extends BukkitRunnable {
    FileConfiguration config = InformDearPlayer.getInstance().getConfig();

    @Override
    public void run() {
        informInResourceWord();
    }

    public List<Player> getOnlinePlayers() {
        return new ArrayList<>(Bukkit.getOnlinePlayers());
    }

    public void informInResourceWord() {
        for (Player player : getOnlinePlayers()) {
            String worldName = config.getString("resource-world-alert.world-name");
            String message = config.getString("resource-world-alert.message");
            if (player.getWorld().getName().equals(worldName)) {
                player.sendMessage(colorize(message));
            }
        }
    }

    public String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
