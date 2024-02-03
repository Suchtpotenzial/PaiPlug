package de.paisc.paiplug.command.types;

import org.bukkit.entity.Player;

public abstract class BasicCommand {

    protected String commandSyntax;
    protected String[] permission;
    protected boolean allowConsole;

    public BasicCommand(String commandSyntax, String permission, boolean allowConsole) {
        this.commandSyntax = commandSyntax;
        this.permission = permission.split(";");
        this.allowConsole = allowConsole;
    }

    public abstract boolean perform(Player p, String[] args);

    public String[] getPermission() {
        return permission;
    }

    public String getCommandSyntax() {
        return commandSyntax;
    }

    public boolean isAllowConsole() {
        return allowConsole;
    }
}
