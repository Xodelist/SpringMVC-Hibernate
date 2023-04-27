package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
@Component
public class UserService {

    private UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }
    @Transactional
    public User getUser(Integer id) {
        return dao.getUser(id);
    }
    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }
    @Transactional
    public List<User> getUsers() {
        return dao.getUsers();
    }
    @Transactional
    public void editUser(User user, Integer id) {
        dao.editUser(user,id);
    }
    @Transactional
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }
}
