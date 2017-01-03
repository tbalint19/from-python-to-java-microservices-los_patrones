package Service;

import Controller.GoogleApiController;

/**
 * Created by balint on 1/3/17.
 */
public class CostCalculator {

    private String target;
    private String webshop;
    private double baseFee;
    private double distanceMultiplier;

    public CostCalculator (String target, String webshop) {
        this.target = target;
        this.webshop = webshop;
        this.baseFee = 3;
        this. distanceMultiplier = 1;
    }

    public double getFeeFromDistance() {
        GoogleApiController helper = new GoogleApiController();

        double distance = helper.getDistance(target, webshop);
        double distanceFee = distance * distanceMultiplier;

        return distanceFee;
    }

    public double getFee() {
        double additionalFee = 0;

        additionalFee += getFeeFromDistance();

        double fee = baseFee + additionalFee;
        return fee;
    }
}
