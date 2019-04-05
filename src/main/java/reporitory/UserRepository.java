package reporitory;

import entity.User;

import java.util.List;

public interface UserRepository {

    User getById(Long id);

    User getByNameByPass(String name, String pass);

    List<User> getAll();

    boolean add(User entity);
    boolean update(User entity);
    boolean delete(User entity);


}
