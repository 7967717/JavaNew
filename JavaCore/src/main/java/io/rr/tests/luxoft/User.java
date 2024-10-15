package io.rr.tests.luxoft;

import java.util.ArrayList;
import java.util.List;


public final class User {
    private int id;
    private String name;

    private List<Friend> friends;

    public User(int id, String name, List<Friend> friends) {
        this.id = id;
        this.name = name;
        this.friends = new ArrayList<>(friends);
    }

    public List<Friend> getFriends() {

        return new ArrayList<>(friends);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
