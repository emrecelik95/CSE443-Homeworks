package sample;

/**
 *  OraSuit
 */
public class OraSuit implements ISuit {

    /**
     * overriding price
     * @return
     * price
     */
    @Override
    public float getPrice() {
        return 1500;
    }

    /**
     * overriding weigth
     * @return
     * weigth
     */
    @Override
    public float getWeigth() {
        return 30;
    }
}
