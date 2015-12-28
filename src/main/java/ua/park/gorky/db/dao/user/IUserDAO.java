package ua.park.gorky.db.dao.user;

import org.springframework.stereotype.Repository;
import ua.park.gorky.core.entity.User;

import java.util.List;

/**
 * Created by Владислав on 16.11.2015.
 */
@Repository
public interface IUserDAO {

    User getUserById(int id);

    List<User> getAllUsers();

    User getUserByLoginPassword(User user);

    User getUserByLogin(String login);

    void addUser(User user);

    void deleteUser(User user);

    void updateUserPassword(User user);

    void updateUserStatus(User user);

    void checkForMatches(User user);

}
