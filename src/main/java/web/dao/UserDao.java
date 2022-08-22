package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void delete(Long id);

    User get(Long id);

    void update(User user);

    List<User> allUsers();
}
