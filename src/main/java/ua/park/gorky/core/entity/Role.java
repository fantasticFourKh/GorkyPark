package ua.park.gorky.core.entity;

/**
 * Created by Владислав on 16.11.2015.
 */
public enum Role {

    USER, ADMIN;

    public String getName() {
        return toString();
    }

    @Override
    public String toString() {
        switch(this) {
            case USER: return "user";
            case ADMIN: return "admin";
            default: throw new IllegalArgumentException();
        }
    }

    public int getId() {
        switch(this) {
            case ADMIN: return 1;
            case USER: return 2;
            default: throw new IllegalArgumentException();
        }
    }

}

