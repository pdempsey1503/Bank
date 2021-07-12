package me.patrick.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Cache<K, V> {

    protected final Map<K, V> map;

    public Cache() {
        this.map = new HashMap<>();
    }

    public abstract void save();

    public abstract void load();
}
