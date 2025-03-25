package ru.sber.base.syntax.other.shell.commands;

import ru.sber.base.syntax.other.shell.Shell;
import ru.sber.base.syntax.other.shell.api.DocumentedShellCommand;

public final class ExitCommand extends DocumentedShellCommand {
    private final Shell shell;

    public ExitCommand(Shell shell) {
        super("завершает работу приложения");
        this.shell = shell;
    }

    @Override
    public void execute() {
        this.shell.dispose();
    }
}
