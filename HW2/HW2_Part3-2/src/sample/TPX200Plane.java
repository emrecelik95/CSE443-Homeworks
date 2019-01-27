package sample;

/**
 *  TPX 200 Model Plane
 */
public class TPX200Plane extends Plane{

    /**
     * Just initializes members so that abstract methods will work
     * to simulate this plane successfully.
     * @param ingredientFactory
     * Ingredient Factory
     */
    public TPX200Plane(PlaneIngredientFactory ingredientFactory){

        purpose = "Domestic and short international flights";
        skeleton = "Nickel alloy";
        engine = "Twin jet engine";
        seating = 100;
        engineInjectionType = ingredientFactory.createEngineInjectionType();
        seatingCover = ingredientFactory.createSeatingCover();

    }

}
