package org.example.test.nwusBedwars.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.example.test.nwusBedwars.NwusBedwars;

public class ConfigManager {
    private final FileConfiguration config;

    public ConfigManager() {
        NwusBedwars plugin = NwusBedwars.getInstance();
        plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
    }

    public String getArenaName() {
        return config.getString("arena.default.name", "default");
    }
}
