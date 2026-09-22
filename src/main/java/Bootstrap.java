import io.javalin.config.RoutesConfig;
import modules.UserModule;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Bootstrap {
    private final Jdbi jdbi;

    public Bootstrap() {
        String host = requiredEnv("DB_HOST");
        String port = requiredEnv("DB_PORT");
        String database = requiredEnv("DB_NAME");
        String user = requiredEnv("DB_USER");
        String password = requiredEnv("DB_PASSWORD");
        String url = "jdbc:mysql://%s:%s/%s".formatted(host, port, database);

        jdbi = Jdbi.create(url, user, password);
        jdbi.installPlugin(new SqlObjectPlugin());
    }

    public void setupModules(RoutesConfig routesConfig) {
        UserModule.setup(jdbi, routesConfig);
    }

    private static String requiredEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required environment variable: " + name);
        }
        return value;
    }
}
