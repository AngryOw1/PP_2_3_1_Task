package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User showUserById(int id);

    void save(User user);

    void updateUser(int id, User updatedUser);
    void delete(int id);

}
