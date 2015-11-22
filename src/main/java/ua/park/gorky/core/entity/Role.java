package ua.park.gorky.core.entity;

/**
 * Created by Владислав on 16.11.2015.
 */
public enum Role {

    ADMIN(1), USER(2);

    private int id;

    private Role(int id) {
        this.id = id;
    }

    public String getName() {
        return toString();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static Role getRole(User user) {
        int roleId = user.getIdRole();
        return Role.values()[roleId - 1];
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setIdRole(1);
        System.out.println(Role.getRole(user));
        System.out.println(Role.ADMIN.getId());
    }

}

