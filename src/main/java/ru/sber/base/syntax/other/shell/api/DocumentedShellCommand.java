package ru.sber.base.syntax.other.shell.api;

public abstract class DocumentedShellCommand implements ShellCommand {
    private final String description;

    public DocumentedShellCommand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
