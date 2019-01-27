package sample;

/**
 *  TPX 100 Model Plane
 */
public class TPX100Plane extends Plane {

    /**
     * Just initializes members so that abstract methods will work
     * to simulate this plane successfully.
     * @param ingredientFactory
     * Ingredient Factory
     */
    public TPX100Plane(PlaneIngredientFactory ingredientFactory){

        purpose = "Domestic flights";
        skeleton = "Aluminum alloy";
        engine = "Single jet engine";
        seating = 50;
        engineInjectionType = ingredientFactory.createEngineInjectionType();
        seatingCover = ingredientFactory.createSeatingCover();

    }

}
