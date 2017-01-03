package Controller;

import Service.CostCalculator;
import spark.Request;

import java.util.HashMap;

/**
 * Created by balint on 1/3/17.
 */
public class CostCalculatorController extends JsonTransformer {

    public String calculatePostalCost (Request request) {
        String target = request.queryParams("target");
        String webshop = request.queryParams("webshop");

        CostCalculator service = new CostCalculator(target, webshop);
        double fee = service.getFee();

        HashMap responseData = new HashMap();
        responseData.put("cost", fee);

        String responseJson = stringify(responseData);
        return responseJson;
    }
}
