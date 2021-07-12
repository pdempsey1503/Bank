package me.patrick.command.loggedin;

import me.patrick.kiosk.KioskContext;

public class LogoutCommand extends LoggedInCommand {

    public LogoutCommand(KioskContext kioskContext) {
        super(kioskContext);
    }

    @Override
    public void run(String[] arguments) {
        kioskContext.logout();

        System.out.println("Logged out!");
    }
}