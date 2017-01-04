import Controller.CostCalculatorController;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

/**
 * Created by balint on 1/3/17.
 */
public class Main {

    public static void main(String[] args) {

        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFiles.location("/public");
        port(9999);

        get("/api", new Route(){
            @Override
            public String handle(Request request, Response response) throws Exception {
                CostCalculatorController controller = new CostCalculatorController(request);
                String responseJSON = controller.calculatePostalCost();
                return responseJSON;
            }
        });

    }
}
