package sample;

/**
 *  Abstract Class for Plane Ingredient Factory
 */
public abstract class PlaneIngredientFactory {

    /**
     *  Engine Injection Type
     */
    protected String engineInjectionType;
    /**
     *  Seating Cover
     */
    protected String seatingCover;

    /**
     * creates engine injection type using member
     * (sub-classes initializes the member)
     * @return
     * Engine Injection Type
     */
    public String createEngineInjectionType() {
        return engineInjectionType;
    }
    /**
     * creates seating cover using member
     * (sub-classes initializes the member)
     * @return
     * Seating Cover
     */
    public String createSeatingCover() {
        return seatingCover;
    }

}
