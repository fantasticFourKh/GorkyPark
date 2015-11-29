package ua.park.gorky.core.service.api;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.RoleBean;
import ua.park.gorky.core.entity.Role;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public interface IRoleService {
    void create(RoleBean bean);

    List<Role> getAll();

    Role get(String name);

    Role get(int id);
}
