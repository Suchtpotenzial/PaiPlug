package de.paisc.paiplug.messages;

import org.bukkit.entity.Player;

public class PlayerIO {

    public static void error(Player player, String message) {
        player.sendMessage(LogLevel.ERROR + message);
    }

    public static void info(Player player, String message) {
        player.sendMessage(LogLevel.INFO + message);
    }

    public static void debug(Player player, String message) {
        player.sendMessage(LogLevel.DEBUG + message);
    }

    public static void verbose(Player player, String message) {
        player.sendMessage(LogLevel.VERBOSE + message);
    }
}
