package me.patrick.json.deserializer;

import com.google.gson.*;
import me.patrick.model.user.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserListDeserializer implements JsonDeserializer<List<User>> {

    @Override
    public List<User> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<User> userList = new ArrayList<>();

        JsonObject object = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> stringJsonElementEntry : object.entrySet()) {
            String id = stringJsonElementEntry.getKey();
            JsonObject userObject = stringJsonElementEntry.getValue().getAsJsonObject();
            String userName = userObject.get("username").getAsString();
            String password = userObject.get("password").getAsString();

            User user = new User(id, userName, password);
            userList.add(user);
        }


        return userList;
    }
}
