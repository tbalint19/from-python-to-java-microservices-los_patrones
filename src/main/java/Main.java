import static spark.Spark.*;

/**
 * Created by balint on 1/3/17.
 */
public class Main {

    public static void main(String[] args) {

        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFiles.location("/public");
        port(9999);

        get("/", (req, res) -> (req));

    }
}
