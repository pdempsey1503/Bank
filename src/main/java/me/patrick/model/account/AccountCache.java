package me.patrick.model.account;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.patrick.json.deserializer.AccountListDeserializer;
import me.patrick.json.serializer.AccountListSerializer;
import me.patrick.model.Cache;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AccountCache extends Cache<String, Account> {

    private final File accountsFile = new File(System.getProperty("user.dir"), "accounts.json");

    private final Gson gson;
    private final Type listType;

    public AccountCache() {
        // create gson
        listType = new TypeToken<List<Account>>() {
        }.getType();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(listType, new AccountListDeserializer())
                .registerTypeAdapter(listType, new AccountListSerializer())
                .create();

        // load
        load();
    }

    @Override
    public void load() {
        try {
            List<Account> accountsList = gson.fromJson(Files.readString(accountsFile.toPath()), listType);

            for (Account account : accountsList) {
                map.put(account.getId(), account);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        String json = gson.toJson(new ArrayList<>(map.values()), listType);
        try {
            Files.writeString(accountsFile.toPath(), json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        load();
    }

    public Account getByUserIdAndName(String userId, String accountName) {
        return map.values()
                .stream()
                .filter(account -> account.getUserId().equals(userId))
                .filter(account -> account.getName().equals(accountName))
                .findFirst()
                .orElse(null);
    }
}