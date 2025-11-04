package org.example.test.nwusBedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.example.test.nwusBedwars.commands.JoinCommand;
import org.example.test.nwusBedwars.commands.StartCommand;
import org.example.test.nwusBedwars.game.GameManager;
import org.example.test.nwusBedwars.listeners.BlockBreakListener;
import org.example.test.nwusBedwars.listeners.GameListener;
import org.example.test.nwusBedwars.listeners.PlayerJoinListener;

public final class NwusBedwars extends JavaPlugin {

    private static NwusBedwars instance;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("BedWars Plugin enabled!");

        // Ініціалізація
        gameManager = new GameManager();

        // Реєстрація подій
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new GameListener(), this);

        // Реєстрація команд
        getCommand("start").setExecutor(new StartCommand());
        getCommand("join").setExecutor(new JoinCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("BedWars Plugin disabled!");
    }

    public static NwusBedwars getInstance() {
        return instance;
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}
