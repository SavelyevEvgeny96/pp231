package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = manager.createQuery("select us from User us").getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return manager.find(User.class,id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        manager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updatedUser) {
        User user = manager.find(User.class,id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        manager.remove(getUserById(id));
    }
}
