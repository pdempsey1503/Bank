package me.patrick.command;

import me.patrick.kiosk.KioskContext;

public abstract class Command {

    protected KioskContext kioskContext;

    public Command(KioskContext kioskContext) {
        this.kioskContext = kioskContext;
    }

    public abstract void execute(String[] arguments);
}
