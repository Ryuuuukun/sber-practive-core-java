package ru.sber.base.syntax.other.shell.commands;

import ru.sber.base.syntax.other.shell.ShellInvoker;
import ru.sber.base.syntax.other.shell.api.DocumentedShellCommand;

public final class HelpCommand extends DocumentedShellCommand {
    private final ShellInvoker invoker;

    public HelpCommand(ShellInvoker invoker) {
        super("выводит список доступных команд");
        this.invoker = invoker;
    }

    @Override
    public void execute() {
        System.out.println("Доступные команды:");
        this.invoker.getCommands().forEach((name, command) -> {
            System.out.print("  " + name + " - ");
            if (command instanceof DocumentedShellCommand documented) {
                System.out.println(documented.getDescription());
            } else {
                System.out.println("информация о поведении данной команды не задокументирована");
            }
        });
    }
}
