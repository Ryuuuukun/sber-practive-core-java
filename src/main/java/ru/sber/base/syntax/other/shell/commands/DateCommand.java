package ru.sber.base.syntax.other.shell.commands;

import ru.sber.base.syntax.other.shell.api.DocumentedShellCommand;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCommand extends DocumentedShellCommand {
    public DateCommand() {
        super("выводит текущую дату");
    }

    @Override
    public void execute() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
    }
}
