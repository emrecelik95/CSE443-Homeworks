package sample;

/**
 *  Laser
 */
public class Laser extends SuitDecorator {

    /**
     * calls super constructor to assign
     * decorated to member ISuit object
     * @param decorated
     * decorated ISuit object
     */
    public Laser(ISuit decorated){
        super(decorated);
    }

    /**
     * overriding getter
     * @return
     *  get suit weigth + laser weigth
     */
    @Override
    public float getWeigth() {
        return super.getWeigth() + 5.5f;
    }

    /**
     * overriding getter
     * @return
     * get suit price + laser price
     */
    @Override
    public float getPrice() {
        return super.getPrice() + 200;
    }

}
