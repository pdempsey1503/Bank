package me.patrick.command.loggedin;

import me.patrick.model.account.Account;
import me.patrick.kiosk.KioskContext;

public class DepositCommand extends LoggedInCommand{
    public DepositCommand(KioskContext kioskContext) {
        super(kioskContext);
    }

    @Override
    public void run(String[] arguments) {
        if(arguments.length != 2) {
            System.out.println("Provide account name then deposit amount");
            return;
        }

        String accountName = arguments[0];

        double depositAmount = Double.parseDouble(arguments[1]);

        Account account = kioskContext.getAccountCache().getByUserIdAndName(
                kioskContext.getLoggedInUser().getId(), accountName);

        if (account == null) {
            System.out.printf("An account with the name %s doesn't exist.%n", accountName);
            return;
        }

        account.setBalance(account.getBalance() + depositAmount);
        kioskContext.getAccountCache().save();
        System.out.printf("Deposited $%f into your %s account.%n", depositAmount, accountName);
    }
}
