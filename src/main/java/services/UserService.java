package services;

import daos.UserDao;
import models.User;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class UserService {
    private final Jdbi jdbi;

    public UserService(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<User> getAllUsers() {
        return jdbi.withExtension(UserDao.class, UserDao::getAllUsers);
    }

    public User getUserById(int id) {
        return jdbi.withExtension(UserDao.class, dao -> dao.getUserById(id));
    }

    /*
    public void createUser(User user) {
        jdbi.useExtension(UserDao.class, dao -> dao.insertUser(
                user.firstName(), user.lastName(),  user.email()
        ));
    }
     **/
}