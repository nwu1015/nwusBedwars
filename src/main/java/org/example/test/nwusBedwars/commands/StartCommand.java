package org.example.test.nwusBedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.example.test.nwusBedwars.NwusBedwars;
import org.example.test.nwusBedwars.game.GameManager;
import org.example.test.nwusBedwars.utils.ChatUtils;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        GameManager gm = NwusBedwars.getInstance().getGameManager();
        String arenaName = args.length > 0 ? args[0] : "default";
        gm.startGame(arenaName);
        sender.sendMessage(ChatUtils.success("Game started in arena " + arenaName));
        return true;
    }
}
