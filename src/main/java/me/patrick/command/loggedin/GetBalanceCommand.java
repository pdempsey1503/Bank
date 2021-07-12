package me.patrick.command.loggedin;

import me.patrick.model.account.Account;
import me.patrick.kiosk.KioskContext;

public class GetBalanceCommand extends LoggedInCommand {

    public GetBalanceCommand(KioskContext kioskContext) {
        super(kioskContext);
    }

    @Override
    public void run(String[] arguments) {
        if (arguments.length <= 0) {
            System.out.println("Please specify an account name!");
            return;
        }

        // get account name
        String accountName = arguments[0];

        // get the account by the name
        Account account = kioskContext.getAccountCache().getByUserIdAndName(
                kioskContext.getLoggedInUser().getId(), accountName);

        if (account == null) {
            System.out.printf("An account with the name %s doesn't exist.%n", accountName);
            return;
        }

        // get balance
        double balance = account.getBalance();

        System.out.printf("Account %s has a balance of $%f.%n", accountName, balance);
    }
}
