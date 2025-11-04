package org.example.test.nwusBedwars.utils;

import org.bukkit.ChatColor;

public class ChatUtils {
    public static String success(String msg) {
        return ChatColor.GREEN + msg;
    }

    public static String error(String msg) {
        return ChatColor.RED + msg;
    }

    public static String info(String msg) {
        return ChatColor.YELLOW + msg;
    }
}
