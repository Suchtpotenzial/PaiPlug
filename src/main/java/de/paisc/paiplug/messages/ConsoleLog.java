package de.paisc.paiplug.messages;

public class ConsoleLog {
    private final LogLevel logLevel;

    /**
     * Erstellt eine Log-Instanz mit Standard Stream (System.out).
     *
     * @param logLevel das LogLevel, ab dem Log-Einträge angezeigt werden sollen.
     */
    public ConsoleLog(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public synchronized void verbose(String message) {
        write(LogLevel.VERBOSE, message);
    }

    public synchronized void verbose(String format, Object... args) {
        write(LogLevel.VERBOSE, String.format(format, args));
    }

    public synchronized void debug(String message) {
        write(LogLevel.DEBUG, message);
    }

    public synchronized void debug(String format, Object... args) {
        write(LogLevel.DEBUG, String.format(format, args));
    }

    public synchronized void info(String message) {
        write(LogLevel.INFO, message);
    }

    public synchronized void info(String format, Object... args) {
        write(LogLevel.INFO, String.format(format, args));
    }

    public synchronized void error(String message) {
        write(LogLevel.ERROR, message);
    }

    public synchronized void error(String format, Object... args) {
        write(LogLevel.ERROR, String.format(format, args));
    }


    public synchronized void write(LogLevel level, String message) {
        int padding = 7 - level.name().length();
        String levelPadding = " ".repeat(Math.max(0, padding));

        String output = String.format("[%s]%s %s", level.name(), levelPadding, message);

        if (level.compareTo(logLevel) >= 0) {
            System.out.println(output);
        }
    }
    public LogLevel getLogLevel() {
        return logLevel;
    }

}
