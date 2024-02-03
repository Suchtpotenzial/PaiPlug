package de.paisc.paiplug.command;

import de.paisc.paiplug.PaiPlug;
import de.paisc.paiplug.command.types.BasicCommand;
import de.paisc.paiplug.messages.ConsoleLog;
import de.paisc.paiplug.messages.PlayerIO;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public abstract class CommandHandler implements CommandExecutor {
    private final ConsoleLog consoleLog;

    protected HashMap<String, BasicCommand> basicPlayerCommands;

    public CommandHandler(PaiPlug paiPlug) {
        this.consoleLog = paiPlug.getConsoleLog();
        registerCommands();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (basicPlayerCommands.containsKey(cmd.getName())) {
            BasicCommand command = basicPlayerCommands.get(cmd.getName());
            if (!command.isAllowConsole()) {
                consoleLog.error("Dieser Command darf nur als Spieler ausgeführt werden!");
                return false;
            }
            Player p = (Player) sender;
            if (!p.hasPermission(command.getPermission()[0]) && !command.getPermission()[0].isEmpty()) {
                consoleLog.verbose("%s -> %s: no perms", p.getName(), cmd.getName());
                PlayerIO.info(p, "Du hast keine Berechtigung für diesen Command!");
                return false;
            }

            if (!command.perform(p,args)) {
                PlayerIO.info(p, "Bitte benutze §e" + command.getCommandSyntax() + "§7!");
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract void registerCommands();

}
