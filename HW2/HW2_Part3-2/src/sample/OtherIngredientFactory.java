package sample;

/**
 *  Other Ingredient Factory
 */
public class OtherIngredientFactory extends PlaneIngredientFactory {

    /**
     *  Initializes engineInjectionType and seatingCover so that
     *  abstract methods use them
     */
    public OtherIngredientFactory(){

        this.engineInjectionType = "Geared turbofan";
        this.seatingCover = "Leather";

    }

}
