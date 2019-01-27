package sample;

/**
 *  TorSuit
 */
public class TorSuit implements ISuit {

    /**
     * overriding price
     * @return
     * price
     */
    @Override
    public float getPrice() {
        return 5000;
    }

    /**
     * overriding weight
     * @return
     * weight
     */
    @Override
    public float getWeigth() {
        return 50;
    }
}
