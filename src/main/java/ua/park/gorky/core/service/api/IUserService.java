package ua.park.gorky.core.service.api;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.AdminUserBean;
import ua.park.gorky.core.bean.UserBean;
import ua.park.gorky.core.entity.User;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public interface IUserService {
    void create(UserBean bean);

    void create(AdminUserBean bean);

    List<User> getAll();

    User get(int id);

    User getByLogin(String login);

    User get(String email);
}
