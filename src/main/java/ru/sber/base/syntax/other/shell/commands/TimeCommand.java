package ru.sber.base.syntax.other.shell.commands;

import ru.sber.base.syntax.other.shell.api.DocumentedShellCommand;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand extends DocumentedShellCommand {
    public TimeCommand() {
        super("выводит текущее время");
    }

    @Override
    public void execute() {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}
