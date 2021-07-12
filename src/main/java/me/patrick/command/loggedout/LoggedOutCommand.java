package me.patrick.command.loggedout;

import me.patrick.command.Command;
import me.patrick.kiosk.KioskContext;

public abstract class LoggedOutCommand extends Command {

    public LoggedOutCommand(KioskContext kioskContext) {
        super(kioskContext);
    }

    @Override
    public void execute(String[] arguments) {
        if (kioskContext.isLoggedIn()) {
            System.out.println("You are logged in!");
            return;
        }

        run(arguments);
    }

    public abstract void run(String[] arguments);
}

