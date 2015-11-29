package ua.park.gorky.core.service;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.AdminUserBean;
import ua.park.gorky.core.bean.UserBean;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.service.api.IUserService;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public class UserService implements IUserService {

    @Override
    public void create(UserBean bean) {

    }

    @Override
    public void create(AdminUserBean bean) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByLogin(String login) {
        return null;
    }

    @Override
    public User get(String email) {
        return null;
    }
}
