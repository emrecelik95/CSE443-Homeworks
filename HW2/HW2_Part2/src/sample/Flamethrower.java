package sample;

/**
 *  Flamethrower
 */
public class Flamethrower extends SuitDecorator {

    /**
     * calls super constructor to assign
     * decorated to member ISuit object
     * @param decorated
     * decorated ISuit object
     */
    public Flamethrower(ISuit decorated){
        super(decorated);
    }

    /**
     * overriding getter
     * @return
     *  get suit weigth + flamethrower weigth
     */
    @Override
    public float getWeigth() {
        return super.getWeigth() + 2;
    }

    /**
     * overriding getter
     * @return
     * get suit price + flamethrower price
     */
    @Override
    public float getPrice() {
        return super.getPrice() + 50;
    }
}
