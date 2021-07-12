package me.patrick.model.account;

public class Account {

    private String id;

    private String userId;

    private String name;

    private Double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(String id, String userId, String name, Double balance) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }
}
