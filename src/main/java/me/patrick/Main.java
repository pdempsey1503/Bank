package me.patrick;

import me.patrick.model.account.AccountCache;
import me.patrick.kiosk.Kiosk;
import me.patrick.model.user.UserCache;

public class Main {

    private UserCache userCache;
    private AccountCache accountCache;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        userCache = new UserCache();
        accountCache = new AccountCache();

        new Kiosk(this);
    }

    public UserCache getUserCache() {
        return this.userCache;
    }

    public AccountCache getAccountCache() {
        return this.accountCache;
    }

}
