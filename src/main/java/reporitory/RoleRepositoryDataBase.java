package reporitory;

import entity.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryDataBase implements RoleRepository {

    @Override
    public Role getById(Long id) {
        Role role = new Role();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from Role where id=:roleId");
            query.setParameter("roleId", id);
            role = (Role)query.getSingleResult();
        }
        catch (HibernateException er){
            System.out.println(er.getMessage());
        }
        finally {
            session.close();
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Role> roleList = new ArrayList<>();
        try{
            Query query = session.createQuery("from Role");
            roleList = query.list();
        }
        catch (HibernateException er) {
            System.out.println(er.getMessage());
        }finally {
            session.close();
        }
        return roleList;
    }

    @Override
    public boolean add(Role role) {
        boolean result = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }
        catch (HibernateException er){
            System.out.println(er.getMessage());
            result = false;
        }
        finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(Role role) {
        boolean result = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        }catch (HibernateException er){
            System.out.println(er.getMessage());
            result = false;
        }
        finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Role role) {
        boolean result = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        }
        catch (HibernateException er){
            System.out.println(er.getMessage()+" /n" +er.getStackTrace());
            result = false;
        }
        finally {
            session.close();
        }
        return result;
    }
}
