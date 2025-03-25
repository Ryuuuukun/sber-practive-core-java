package ru.sber.base.syntax.other.shell;

import ru.sber.base.syntax.other.shell.commands.*;
import ru.sber.base.syntax.other.shell.exception.ShellException;

import java.util.Scanner;

public class Shell {
    private final ShellInvoker invoker;

    private boolean running;

    public Shell() {
        this.invoker = new ShellInvoker();
        this.running = true;

        this.invoker.register("date", new DateCommand());
        this.invoker.register("time", new TimeCommand());
        this.invoker.register("pwd", new PWDCommand());
        this.invoker.register("exit", new ExitCommand(this));
        this.invoker.register("help", new HelpCommand(this.invoker));
    }

    public void launch() {
        Scanner scanner = new Scanner(System.in);

        while (this.running) {
            System.out.print("javash > ");
            try {
                this.invoker.execute(scanner.next().trim());
            } catch (ShellException e) {
                System.out.println("Вызвано исключение: " + e.getMessage());
            }
        }
    }

    public void dispose() {
        this.running = false;
    }
}
