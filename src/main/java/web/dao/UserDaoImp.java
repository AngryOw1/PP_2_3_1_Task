package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User showUserById(int id){
        return entityManager.createQuery("from User", User.class)
                .getResultList().stream().filter(user -> user.getId() == id)
                .findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User userForUpdate = showUserById(id);
        userForUpdate.setName(updatedUser.getName());
        userForUpdate.setSurname(updatedUser.getSurname());
        userForUpdate.setAge(updatedUser.getAge());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(showUserById(id));
    }
}
