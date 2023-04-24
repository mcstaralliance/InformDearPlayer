package com.mcstaralliance.informdearplayer;

import com.mcstaralliance.informdearplayer.task.CheckRunnable;
import org.bukkit.plugin.java.JavaPlugin;

public final class InformDearPlayer extends JavaPlugin {
    private static InformDearPlayer instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        CheckRunnable checkRunnable = new CheckRunnable();
        long interval = getConfig().getLong("resource-world-alert.interval");
        checkRunnable.runTaskTimer(getInstance(), 5L, interval);
    }


    public static InformDearPlayer getInstance(){
        return instance;
    }
}
