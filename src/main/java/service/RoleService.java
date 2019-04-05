package service;

import entity.Role;
import reporitory.RoleRepository;
import reporitory.RoleRepositoryDataBase;

import java.util.List;

public class RoleService {

    private RoleRepository roleRepository ;

    public RoleService(){
        roleRepository = new RoleRepositoryDataBase();
    }

    public List<Role> getAll() {
        return roleRepository.getAll();
    }

    public Role getById(Long id){
        return  roleRepository.getById(id);
    }

    public boolean add(Role Role){
        return roleRepository.add(Role);
    }

    public boolean update(Role Role){
        return roleRepository.update(Role);
    }

    public boolean delete(Role Role) {
        return roleRepository.delete(Role);
    }

}
