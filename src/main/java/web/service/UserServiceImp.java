package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {

    }

    @Transactional
    @Override
    public void delete(User user) {

    }

    @Transactional
    @Override
    public void update(User user) {

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> allUsers() {
        userDao.add(new User("firstName","lastName", "someEmail"));
        return userDao.allUsers();
    }
}
