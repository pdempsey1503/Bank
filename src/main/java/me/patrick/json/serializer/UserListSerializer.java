package me.patrick.json.serializer;

import com.google.gson.*;
import me.patrick.model.account.Account;
import me.patrick.model.user.User;

import java.lang.reflect.Type;
import java.util.List;

public class UserListSerializer implements JsonSerializer<List<User>> {

    private final Gson gson = new Gson();

    @Override
    public JsonElement serialize(List<User> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        for (User user : src) {
            // create json object for the user
            JsonObject accountObject = new JsonObject();

            accountObject.addProperty("username", user.getUsername());
            accountObject.addProperty("password", user.getPassword());

            // add to the json object
            object.add(user.getId(), accountObject);
        }

        return object;
    }
}
