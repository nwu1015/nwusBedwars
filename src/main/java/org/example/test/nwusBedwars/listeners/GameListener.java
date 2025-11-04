package org.example.test.nwusBedwars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.example.test.nwusBedwars.NwusBedwars;
import org.example.test.nwusBedwars.game.*;

public class GameListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        GameManager gm = NwusBedwars.getInstance().getGameManager();
        gm.getArenas().forEach(arena -> {
            if (arena.getPlayers().contains(event.getPlayer())) {
                arena.getPlayers().remove(event.getPlayer());
                if (arena.getPlayers().isEmpty()) {
                    arena.setState(GameState.ENDED);
                }
            }
        });
    }
}
