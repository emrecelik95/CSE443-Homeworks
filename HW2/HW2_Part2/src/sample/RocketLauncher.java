package sample;

/**
 *  RocketLauncher
 */
public class RocketLauncher extends SuitDecorator {

    /**
     * calls super constructor to assign
     * decorated to member ISuit object
     * @param decorated
     * decorated ISuit object
     */
    public RocketLauncher(ISuit decorated){
        super(decorated);
    }

    /**
     * overriding getter
     * @return
     *  get suit weigth + rocketlauncher weigth
     */
    @Override
    public float getWeigth() {
        return super.getWeigth() + 7.5f;
    }

    /**
     * overriding getter
     * @return
     * get suit price + rocketlauncher price
     */
    @Override
    public float getPrice() {
        return super.getPrice() + 150;
    }
}
