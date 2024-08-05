package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

     List<User> getUsers();
     void saveUSer(User user);
     User getUser(long id);
     void deleteUser(long id);
     void updateUser(User user);

}
