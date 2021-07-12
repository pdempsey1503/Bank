package me.patrick.json.deserializer;

import com.google.gson.*;
import me.patrick.model.account.Account;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountListDeserializer implements JsonDeserializer<List<Account>> {

    @Override
    public List<Account> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Account> accountList = new ArrayList<>();

        JsonObject object = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> stringJsonElementEntry : object.entrySet()) {
            String id = stringJsonElementEntry.getKey();
            JsonObject userObject = stringJsonElementEntry.getValue().getAsJsonObject();
            String name = userObject.get("name").getAsString();
            String userId = userObject.get("user_id").getAsString();
            Double balance = userObject.get("balance").getAsDouble();

            Account account = new Account(id, userId, name, balance);
            accountList.add(account);
        }


        return accountList;
    }
}
