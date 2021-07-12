package me.patrick.kiosk;

import me.patrick.Main;
import me.patrick.model.account.AccountCache;
import me.patrick.model.user.User;
import me.patrick.model.user.UserCache;

public class KioskContext {

    private User loggedInUser;
    private UserCache userCache;
    private AccountCache accountCache;

    public KioskContext(Main main) {
        this.loggedInUser = null;

        this.userCache = main.getUserCache();
        this.accountCache = main.getAccountCache();
    }

    public void login(User user) {
        this.loggedInUser = user;
    }

    public void logout() {
        if (this.isLoggedIn()) {
            this.loggedInUser = null;
        }
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    public boolean isLoggedIn() {
        return this.loggedInUser != null;
    }

    public UserCache getUserCache() {
        return userCache;
    }

    public AccountCache getAccountCache() {
        return accountCache;
    }
}
