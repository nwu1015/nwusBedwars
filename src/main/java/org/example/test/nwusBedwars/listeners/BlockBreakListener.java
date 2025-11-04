package org.example.test.nwusBedwars.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.example.test.nwusBedwars.game.BedManager;

public class BlockBreakListener implements Listener {
    private final BedManager bedManager = new BedManager();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (bedManager.isBed(event.getBlock())) {
            event.getPlayer().sendMessage("§cYou broke a bed!");
        }
    }
}
