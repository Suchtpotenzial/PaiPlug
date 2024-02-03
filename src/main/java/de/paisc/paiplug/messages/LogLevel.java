package de.paisc.paiplug.messages;

public enum LogLevel {

    VERBOSE("§7[§8VERBOSE§7] "),
    DEBUG("§7[§9DEBUG§7] "),
    INFO("§7[§aINFO§7] "),
    ERROR("§7[§cERROR§7] ");


    private final String prefix;
    LogLevel(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
