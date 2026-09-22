package modules;

import controllers.UserController;
import io.javalin.config.RoutesConfig;
import org.jdbi.v3.core.Jdbi;
import services.UserService;

public class UserModule extends GenericModule {
    static public void setup(Jdbi jdbi, RoutesConfig routesConfig) {
        UserService userService = new UserService(jdbi);
        UserController userController = new UserController(userService);

        /*
         * Retrieve all available user
         * GET /users
         */
        routesConfig.get("/users", userController::getAll);

        routesConfig.put("/users/:id", userController::getOne);
    }
}
