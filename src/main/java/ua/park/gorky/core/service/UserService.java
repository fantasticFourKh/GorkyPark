package ua.park.gorky.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.AdminUserBean;
import ua.park.gorky.core.bean.UserBean;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.service.api.IUserService;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.transaction.TransactionManager;
import ua.park.gorky.db.transaction.TransactionOperation;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Qualifier("mySqlTransactionManager")
    @Autowired
    private TransactionManager manager;

    @Override
    public void create(UserBean bean) {
        manager.doInTransaction((TransactionOperation<Void>) () -> {
            User user = new User(bean);
            userDAO.addUser(user);
            return null;
        });

    }

    @Override
    public void create(AdminUserBean bean) {
        manager.doInTransaction((TransactionOperation<Void>) () -> {
            User user = new User(bean);
            userDAO.addUser(user);
            return null;
        });
    }

    @Override
    public List<User> getAll() {
        return manager.doInTransaction(() -> userDAO.getAllUsers());
    }

    @Override
    public User get(int id) {
        return manager.doInTransaction(() -> userDAO.getUserById(id));
    }

    @Override
    public User getByLogin(String login) {
        return manager.doInTransaction(() -> userDAO.getUserByLogin(login));
    }

    @Override
    public User get(String email) {
        return null;
    }
}
