package me.patrick.command;

import me.patrick.command.loggedin.DepositCommand;
import me.patrick.command.loggedin.GetBalanceCommand;
import me.patrick.command.loggedin.LogoutCommand;
import me.patrick.command.loggedout.LoginCommand;
import me.patrick.kiosk.KioskContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private Map<String, Command> commandMap;

    public CommandManager(KioskContext kioskContext) {
        commandMap = new HashMap<>();

        // load the commands in to the map

        // logged out
        commandMap.put("login", new LoginCommand(kioskContext));

        // logged in
        commandMap.put("logout", new LogoutCommand(kioskContext));
        commandMap.put("getbalance", new GetBalanceCommand(kioskContext));
        commandMap.put("deposit", new DepositCommand(kioskContext));
    }

    /**
     * Execute a command
     *
     * @param commandString command string
     * @return if the command exists or not
     */
    public boolean run(String commandString) {
        String[] parts = commandString.split(" ");

        Command command = commandMap.get(parts[0]);

        if (command == null) {
            return false;
        }

        String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);
        command.execute(arguments);

        return true;
    }
}
