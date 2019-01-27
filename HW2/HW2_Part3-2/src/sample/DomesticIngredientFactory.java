package sample;

/**
 *  Domestic Ingredient Factory
 */
public class DomesticIngredientFactory extends PlaneIngredientFactory{

    /**
     *  Initializes engineInjectionType and seatingCover so that
     *  abstract methods use them
     */
    public DomesticIngredientFactory(){
        this.engineInjectionType = "Turbojet";
        this.seatingCover = "Velvet";
    }


}
