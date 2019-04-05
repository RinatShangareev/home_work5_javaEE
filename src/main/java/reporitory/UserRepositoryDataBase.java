package reporitory;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDataBase implements UserRepository {

    @Override
    public User getById(Long id) {
        User user = new User();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from User where id=:userId");
            query.setParameter("userId", id);
            Object result = query.getResultList();

            if(result != null && ((List) result).size() > 0)
            {
                user = (User)((List) result).get(0);
            }
            else {
                return null;
            }
        }
        catch (HibernateException er){
            System.out.println(er.getMessage());
        }
        finally {
            session.close();
        }
        return user;
    }

    @Override
    public User getByNameByPass(String name, String pass) {
        User user = new User();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from User where userName=:name AND  password=:pass");
            query.setParameter("name", name);
            query.setParameter("pass", pass);
            Object result = query.getResultList();

            if(result != null && ((List) result).size() > 0)
            {
                user = (User)((List) result).get(0);
            }
            else {
                return null;
            }
        }
        catch (HibernateException er){
            System.out.println(er.getMessage());
        }
        finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> userList = new ArrayList<>();
        try{
            Query query = session.createQuery("from User");
            userList = query.list();
        }
        catch (HibernateException er) {
            System.out.println(er.getMessage());
        }finally {
            session.close();
        }
        return userList;
    }

    @Override
    public boolean add(User user) {
        boolean result = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(user);
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
    public boolean update(User user) {
        boolean result = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(user);
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
    public boolean delete(User user) {
        boolean result = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(user);
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
