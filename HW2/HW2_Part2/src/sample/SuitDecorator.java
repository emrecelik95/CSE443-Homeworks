package sample;

/**
 *  Decorator class for Suits.
 */
public abstract class SuitDecorator implements ISuit {

    /**
     *  Decorated ISuit object.
     */
    protected ISuit suit;

    /**
     *
     * @param decorated
     * decorated ISuit object
     */
    public SuitDecorator(ISuit decorated) {
        suit = decorated;
    }

    /**
     * Price getter
     * @return
     * suit prive
     */
    @Override
    public float getPrice() {
        return suit.getPrice();
    }

    /**
     * Weight getter
     * @return
     * suit weight
     */
    @Override
    public float getWeigth() {
        return suit.getWeigth();
    }
}
