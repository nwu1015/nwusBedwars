package org.example.test.nwusBedwars.game;

import org.bukkit.block.Block;

public class BedManager {
    public boolean isBed(Block block) {
        String type = block.getType().toString().toLowerCase();
        return type.contains("bed");
    }

    public void destroyBed(Block block, Team team) {
        block.breakNaturally();
        team.destroyBed();
        System.out.println("Bed of team " + team.getName() + " destroyed!");
    }
}
