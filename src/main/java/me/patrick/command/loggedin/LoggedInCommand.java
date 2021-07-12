package me.patrick.command.loggedin;

import me.patrick.command.Command;
import me.patrick.kiosk.KioskContext;

public abstract class LoggedInCommand extends Command {

    public LoggedInCommand(KioskContext kioskContext) {
        super(kioskContext);
    }

    @Override
    public void execute(String[] arguments) {
        if (!kioskContext.isLoggedIn()) {
            System.out.println("You aren't logged in!");
            return;
        }

        run(arguments);
    }

    public abstract void run(String[] arguments);
}
