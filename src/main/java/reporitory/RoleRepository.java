package reporitory;

import entity.Role;

import java.util.List;

public interface RoleRepository {

    Role getById(Long id);

    List<Role> getAll();

    boolean add(Role entity);
    boolean update(Role entity);
    boolean delete(Role entity);

}
