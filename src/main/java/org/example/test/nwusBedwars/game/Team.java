package org.example.test.nwusBedwars.game;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Player> members = new ArrayList<>();
    private boolean bedAlive = true;

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        members.add(player);
    }

    public String getName() {
        return name;
    }

    public boolean isBedAlive() {
        return bedAlive;
    }

    public void destroyBed() {
        bedAlive = false;
    }

    public List<Player> getMembers() {
        return members;
    }
}
