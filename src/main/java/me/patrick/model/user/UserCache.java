package me.patrick.model.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.patrick.json.deserializer.UserListDeserializer;
import me.patrick.json.serializer.UserListSerializer;
import me.patrick.model.Cache;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.List;

public class UserCache extends Cache<String, User> {

    private final File usersFile = new File(System.getProperty("user.dir"), "users.json");

    private final Gson gson;
    private final Type listType;

    public UserCache() {
        // create gson
        listType = new TypeToken<List<User>>() {
        }.getType();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(listType, new UserListDeserializer())
                .registerTypeAdapter(listType, new UserListSerializer())
                .create();

        // load
        load();
    }

    @Override
    public void load() {
        try {
            List<User> userList = gson.fromJson(Files.readString(usersFile.toPath()), listType);

            for (User user : userList) {
                map.put(user.getId(), user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            gson.toJson(map.values(), new FileWriter(usersFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        load();
    }

    public User getByUsername(String username) {
        return map.entrySet().stream()
                .filter(entrySet -> entrySet.getValue().getUsername().equals(username))
                .map(stringUserEntry -> stringUserEntry.getValue())
                .findFirst()
                .orElse(null);
    }
}
