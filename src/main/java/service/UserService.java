package service;

import entity.User;
import reporitory.UserRepository;
import reporitory.UserRepositoryDataBase;
import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepositoryDataBase();
    }

    public List<User> getAll() {
      return userRepository.getAll();
    }

    public User getById(Long id){
       return  userRepository.getById(id);
    }

    public User getByNameByPass(String name, String pass){
        return  userRepository.getByNameByPass(name, pass);
    }

    public boolean add(User user){
        return userRepository.add(user);
    }

    public boolean update(User user){
        return userRepository.update(user);
    }

    public boolean delete(User user) {
        return userRepository.delete(user);
    }

}
