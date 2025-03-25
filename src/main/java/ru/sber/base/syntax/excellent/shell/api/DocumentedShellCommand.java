package ru.sber.base.syntax.excellent.shell.api;

public abstract class DocumentedShellCommand implements ShellCommand {
    private final String description;

    public DocumentedShellCommand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
