package org.example.test.nwusBedwars;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.test.nwusBedwars.commands.ArenaCMD;
import org.example.test.nwusBedwars.configs.BlocksConfig;
import org.example.test.nwusBedwars.configs.LocationsConfig;
import org.example.test.nwusBedwars.configs.OtherConfig;
import org.example.test.nwusBedwars.configs.SpawnerLocationsConfig;
import org.example.test.nwusBedwars.events.BoardListener;
import org.example.test.nwusBedwars.events.GameEvents;
import org.example.test.nwusBedwars.gui.GuiEvent;
import org.example.test.nwusBedwars.util.Board;
import org.example.test.nwusBedwars.util.Util;


import java.util.ArrayList;
import java.util.List;


public class NwusBedwars extends JavaPlugin {

    private static NwusBedwars instance;

    @Override
    public void onEnable() {
        instance = this;
        createConfigs();
        getCommand("bw").setExecutor(new ArenaCMD());
        Bukkit.getPluginManager().registerEvents(new GameEvents(), this);
        Bukkit.getPluginManager().registerEvents(new BoardListener(), this);
        Bukkit.getPluginManager().registerEvents(new GuiEvent(), this);
    }

    private void createConfigs(){
        saveResource("blocks.yml", false);
        BlocksConfig.setData(new BlocksConfig("blocks.yml"));
        BlocksConfig.getData().save();
        saveResource("locations.yml", false);
        LocationsConfig.setData(new LocationsConfig("locations.yml"));
        LocationsConfig.getData().save();
        saveResource("spawnerLocations.yml", false);
        SpawnerLocationsConfig.setData(new SpawnerLocationsConfig("spawnerLocations.yml"));
        SpawnerLocationsConfig.getData().save();
        saveResource("other.yml", false);
        OtherConfig.setData(new OtherConfig("other.yml"));
        OtherConfig.getData().save();
    }

    @Override
    public void onDisable() {
        for(Arena arena : Arena.arenas){
            Board.removeScoreboard(arena.getPlayers());
            for(Player player : arena.getPlayers()) {
                player.teleport(arena.getPlayersLocation().get(player));
                player.getInventory().setContents(arena.getPlayersInventories().get(player));
                player.setGameMode(GameMode.SURVIVAL);
            }
            for(Team team : arena.getTeamsList()){
                team.getPlayers().clear();
                team.getBed().setBroken(false);
            }
            Bukkit.unloadWorld(arena.getArenaName(), false);
            arena.getTeamsList().clear();
            Arena.arenas.remove(arena);
        }
        for(Thread thread : Util.getThreads()){
            thread.interrupt();
        }
    }

    public static NwusBedwars getInstance() {
        return instance;
    }
}
