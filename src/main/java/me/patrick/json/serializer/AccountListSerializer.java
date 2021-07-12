package me.patrick.json.serializer;

import com.google.gson.*;
import me.patrick.model.account.Account;

import java.lang.reflect.Type;
import java.util.Collection;

public class AccountListSerializer implements JsonSerializer<Collection<Account>> {

    @Override
    public JsonElement serialize(Collection<Account> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        for (Account account : src) {
            // create json object for the account
            JsonObject accountObject = new JsonObject();

            accountObject.addProperty("name", account.getName());
            accountObject.addProperty("user_id", account.getUserId());
            accountObject.addProperty("balance", account.getBalance());

            // add to the json object
            object.add(account.getId(), accountObject);
        }

        return object;
    }
}
