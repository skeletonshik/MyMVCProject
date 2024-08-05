package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();

    void saveUser(User user);

    User getUser(long id);
    void deleteUser(long id);
    void updateUser(User user);
}
