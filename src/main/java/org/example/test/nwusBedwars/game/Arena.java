package org.example.test.nwusBedwars.game;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final String name;
    private GameState state = GameState.WAITING;
    private final List<Player> players = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();

    public Arena(String name) {
        this.name = name;
        teams.add(new Team("Red"));
        teams.add(new Team("Blue"));
    }

    public String getName() {
        return name;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
