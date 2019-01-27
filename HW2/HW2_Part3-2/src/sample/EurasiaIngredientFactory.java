package sample;

/**
 *  Eurasia Ingredient Factory
 */
public class EurasiaIngredientFactory extends  PlaneIngredientFactory {

    /**
     *  Initializes engineInjectionType and seatingCover so that
     *  abstract methods use them
     */
    public EurasiaIngredientFactory(){

        this.engineInjectionType = "Turbofan";
        this.seatingCover = "Linen";

    }

}
