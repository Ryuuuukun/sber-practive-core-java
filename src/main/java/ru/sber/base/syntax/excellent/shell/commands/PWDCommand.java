package ru.sber.base.syntax.excellent.shell.commands;

import ru.sber.base.syntax.excellent.shell.api.DocumentedShellCommand;

public class PWDCommand extends DocumentedShellCommand {
    public PWDCommand() {
        super("выводит текущий рабочий каталог");
    }

    @Override
    public void execute() {
        System.out.println(System.getProperty("user.dir"));
    }
}
