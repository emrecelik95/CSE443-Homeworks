package sample;

/**
 *  Other Plane Store Extends PlaneStore
 */
public class OtherPlaneStore extends PlaneStore {


    /**
     *  initializes own ingredient factory
     */
    public OtherPlaneStore() {
        ingredientFactory = new OtherIngredientFactory();
    }

}
