package org.example.test.nwusBedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.test.nwusBedwars.NwusBedwars;
import org.example.test.nwusBedwars.game.Arena;
import org.example.test.nwusBedwars.utils.ChatUtils;

public class JoinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Arena arena = NwusBedwars.getInstance().getGameManager().getArena("default");
        arena.addPlayer(player);
        player.sendMessage(ChatUtils.info("You joined arena: " + arena.getName()));
        return true;
    }
}
