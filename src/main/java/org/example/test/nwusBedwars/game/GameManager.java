package org.example.test.nwusBedwars.game;

import java.util.*;

public class GameManager {
    private final Map<String, Arena> arenas = new HashMap<>();

    public GameManager() {
        // Демонстраційна арена
        arenas.put("default", new Arena("default"));
    }

    public Arena getArena(String name) {
        return arenas.get(name);
    }

    public void startGame(String arenaName) {
        Arena arena = arenas.get(arenaName);
        if (arena != null) {
            arena.setState(GameState.RUNNING);
            System.out.println("Game started in arena: " + arenaName);
        }
    }

    public void stopGame(String arenaName) {
        Arena arena = arenas.get(arenaName);
        if (arena != null) {
            arena.setState(GameState.ENDED);
            System.out.println("Game stopped in arena: " + arenaName);
        }
    }

    public Collection<Arena> getArenas() {
        return arenas.values();
    }
}
