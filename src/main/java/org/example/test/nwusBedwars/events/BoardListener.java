package org.example.test.nwusBedwars.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.example.test.nwusBedwars.util.Board;


public class BoardListener implements Listener {

    @EventHandler
    public void updateScoreboard(PlayerMoveEvent e){
        Board.createScoreboard();
    }

}