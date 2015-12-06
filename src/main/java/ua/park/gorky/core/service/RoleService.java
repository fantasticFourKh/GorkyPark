package ua.park.gorky.core.service;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.RoleBean;
import ua.park.gorky.core.entity.Role;
import ua.park.gorky.core.service.api.IRoleService;

import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public class RoleService implements IRoleService {
    @Override
    public void create(RoleBean bean) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role get(String name) {
        return null;
    }

    @Override
    public Role get(int id) {
        return null;
    }
}
