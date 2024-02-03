package de.paisc.paiplug;

import de.paisc.paiplug.messages.ConsoleLog;

public class PaiPlug {

    private final ConsoleLog consoleLog;

    public PaiPlug(ConsoleLog consoleLog) {
        this.consoleLog = consoleLog;
        System.out.println("PaiPlug initialized!");
    }


    public ConsoleLog getConsoleLog() {
        return consoleLog;
    }
}

