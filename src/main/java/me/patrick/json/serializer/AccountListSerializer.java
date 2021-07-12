package me.patrick.json.serializer;

import com.google.gson.*;
import me.patrick.model.account.Account;

import java.lang.reflect.Type;
import java.util.List;

public class AccountListSerializer implements JsonSerializer<List<Account>> {

    private final Gson gson = new Gson();

    @Override
    public JsonElement serialize(List<Account> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        System.out.println("----");
        for (Account account : src) {
            System.out.println("Serializing account = " + account.getName());
            // create json object for the account
            JsonObject accountObject = new JsonObject();

            accountObject.addProperty("name", account.getName());
            accountObject.addProperty("user_id", account.getId());
            accountObject.addProperty("balance", account.getBalance());

            // add to the json object
            object.add(account.getId(), accountObject);

            System.out.println("Serialized account -> " + accountObject.getAsString());
        }
        System.out.println("----");
        System.out.println("object = " + object);

        return object;
    }
}
