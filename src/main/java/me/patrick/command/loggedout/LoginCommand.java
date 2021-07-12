package me.patrick.command.loggedout;

import me.patrick.kiosk.KioskContext;
import me.patrick.model.user.User;

import java.util.Scanner;

public class LoginCommand extends LoggedOutCommand {

    public LoginCommand(KioskContext kioskContext) {
        super(kioskContext);
    }

    @Override
    public void run(String[] arguments) {
        // new scanner
        Scanner scanner = new Scanner(System.in);
        // get the username
        System.out.print("Username: ");
        String username = scanner.nextLine();
        // get password
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // get user by username
        User applicable = kioskContext.getUserCache().getByUsername(username);

        // compare passwords
        if (applicable == null || !applicable.getPassword().equals(password)) {
            System.out.println("Incorrect Username/Password");
            return;
        }

        kioskContext.login(applicable);

        System.out.printf("Logged in as %s!%n", applicable.getUsername());
    }
}
