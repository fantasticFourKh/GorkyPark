package ua.park.gorky.db.dao.user;

import ua.park.gorky.core.entity.User;

/**
 * Created by Владислав on 16.11.2015.
 */
public interface IUserDAO {

    User getUserById(int id);

    User getUserByLogin(String login);

    void addUser(User user);

    void deleteUser(User user);

    void updateUserPassword(User user);

    void updateUserStatus(User user);

}
