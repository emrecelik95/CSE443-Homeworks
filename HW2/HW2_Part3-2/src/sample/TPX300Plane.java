package sample;

/**
 *  TPX 300 Model Plane
 */
public class TPX300Plane extends Plane {

    /**
     * Just initializes members so that abstract methods will work
     * to simulate this plane successfully.
     * @param ingredientFactory
     * Ingredient Factory
     */
    public TPX300Plane(PlaneIngredientFactory ingredientFactory){

        purpose = "Transatlantic flights";
        skeleton = "Titanium alloy";
        engine = "Quadro jet engine";
        seating = 250;
        engineInjectionType = ingredientFactory.createEngineInjectionType();
        seatingCover = ingredientFactory.createSeatingCover();

    }

}
