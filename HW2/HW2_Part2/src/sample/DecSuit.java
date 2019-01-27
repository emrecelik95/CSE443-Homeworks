package sample;

/**
 *  DecSuit
 */
public class DecSuit implements ISuit {

    /**
     * overriding getter
     * @return
     * weight
     */
    @Override
    public float getWeigth() {
        return 25;
    }

    /**
     * overriding getter
     * @return
     * prive
     */
    @Override
    public float getPrice() {
        return 500;
    }
}
