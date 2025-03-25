package ru.sber.base.syntax.excellent.shell;

import org.jetbrains.annotations.NotNull;
import ru.sber.base.syntax.excellent.shell.api.ShellCommand;
import ru.sber.base.syntax.excellent.shell.exception.NotFoundShellCommandException;

import java.util.HashMap;
import java.util.Map;

public class ShellInvoker {
    private final Map<String, ShellCommand> commands;

    public ShellInvoker(Map<String, ShellCommand> commands) {
        this.commands = commands;
    }

    public ShellInvoker() {
        this(new HashMap<>());
    }

    public void register(@NotNull String name, @NotNull ShellCommand command) {
        this.commands.put(name, command);
    }

    public void execute(@NotNull String name) {
        if (this.commands.containsKey(name)) {
            this.commands.get(name).execute();
        } else {
            throw new NotFoundShellCommandException("неизвестная команда '" + name + "'");
        }
    }

    public Map<String, ShellCommand> getCommands() {
        return this.commands;
    }
}
