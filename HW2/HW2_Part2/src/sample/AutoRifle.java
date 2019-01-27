package sample;

/**
 * AutoRifle Decorator
 */
public class AutoRifle extends SuitDecorator {

    /**
     * calls super constructor to assign
     * decorated to member ISuit object
     * @param decorated
     * decorated ISuit object
     */
    public AutoRifle(ISuit decorated){
        super(decorated);
    }

    /**
     * overriding getter
     * @return
     *  get suit weigth + autorifle weigth
     */
    @Override
    public float getWeigth() {
        return super.getWeigth() + 1.5f;
    }

    /**
     * overriding getter
     * @return
     * get suit price + autorifle price
     */
    @Override
    public float getPrice() {
        return super.getPrice() + 30;
    }
}
