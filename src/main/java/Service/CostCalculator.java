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
    private double foreignMultiplier;

    public CostCalculator (String target, String webshop) {
        this.target = target;
        this.webshop = webshop;
        this.baseFee = 3;
        this.distanceMultiplier = 1;
        this.foreignMultiplier = 1.5;
    }

    public double getFeeFromDistance() {
        GoogleApiController helper = new GoogleApiController();

        double distance = helper.getDistance(target, webshop);
        double distanceFee = distance * distanceMultiplier;

        return distanceFee;
    }

    public double getFeeForForeignTransfer() {
        GoogleApiController helper = new GoogleApiController();

        boolean is_same = helper.countryCheck(target, webshop);
        if (is_same) {
            return 1;
        }
        return foreignMultiplier;
    }

    public double getFee() {
        double additionalFee = 0;

        additionalFee += getFeeFromDistance();
        additionalFee *= getFeeForForeignTransfer();

        double fee = baseFee + additionalFee;
        return fee;
    }
}
