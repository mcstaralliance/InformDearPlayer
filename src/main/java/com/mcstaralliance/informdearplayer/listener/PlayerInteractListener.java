package com.mcstaralliance.informdearplayer.listener;

import com.mcstaralliance.informdearplayer.InformDearPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    FileConfiguration config = InformDearPlayer.getInstance().getConfig();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getMaterial() == Material.WOOD_HOE) {
            String message = config.getString("resource-world-alert.message");
            player.sendMessage(colorize(message));
        }
    }


    public String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
