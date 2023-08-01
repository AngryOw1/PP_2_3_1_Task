package web.service;
import web.model.User;
import java.util.List;

public interface UserService {
    List<User> index();
    User showUserById(int count);
    void save(User user);
    void updateUser(int id, User updatedUser);
    void delete(int id);
}
