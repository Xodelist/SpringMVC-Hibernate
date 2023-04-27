package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Component
public class UserDao {
    @PersistenceContext
    private EntityManager manager;

    public User getUser(Integer id) {
        Query query = manager.createQuery("From User where id = :id");
        query.setParameter("id",id);
        return ((User) query.getSingleResult());
    }
    public List<User> getUsers() {
        return manager.createQuery("From User ").getResultList();
    }
    public void addUser(User user) {
        manager.persist(user);
    }
    public void editUser(User user, Integer id) {
        Query query = manager.createQuery("UPDATE User SET first_name = :name, age = :age where id = :id");
        query.setParameter("name",user.getFirst_name()).setParameter("age",user.getAge()).setParameter("id", id);
        query.executeUpdate();
    }
    public void deleteUser(Integer id) {
        manager.remove(getUser(id));
    }
}
