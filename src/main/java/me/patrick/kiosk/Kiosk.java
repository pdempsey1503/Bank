package me.patrick.kiosk;

import me.patrick.Main;
import me.patrick.command.CommandManager;

import java.util.Scanner;

public class Kiosk {

    private Main main;
    private KioskContext kioskContext;
    private CommandManager commandManager;

    public Kiosk(Main main) {
        this.main = main;

        this.kioskContext = new KioskContext(main);
        this.commandManager = new CommandManager(kioskContext);

        open();
    }

    public void open() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                break;
            }

            boolean commandExists = commandManager.run(line);

            if (!commandExists) {
                System.out.println("Sorry, we can't find that command!");
            }
        }
    }

}
