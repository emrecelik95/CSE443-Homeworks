package sample;

/**
 *  Domestic Plane Store Extends PlaneStore
 */
public class DomesticPlaneStore extends PlaneStore {

    /**
     *  initializes own ingredient factory
     */
    public DomesticPlaneStore() {
        ingredientFactory = new DomesticIngredientFactory();
    }

}
