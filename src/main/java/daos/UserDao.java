package daos;

import models.User;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

// 2. Jdbi DAO Interface
public interface UserDao {

    @SqlQuery("""
            SELECT id, first_name, last_name, address, email, password,
                   role, is_active, created_at, updated_at
            FROM users
            """)
    @RegisterConstructorMapper(User.class)
    List<User> getAllUsers();


    @SqlQuery("SELECT * FROM users WHERE id = :id")
    @RegisterConstructorMapper(User.class)
    User getUserById(@Bind("id") int id);

    /*
    @SqlUpdate("INSERT INTO users (name, lastName, adress, email) VALUES (:name, :email)")
    void insertUser(@Bind("name") String name, @Bind("email") String email);
    **/
}