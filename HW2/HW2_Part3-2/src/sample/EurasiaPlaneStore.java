package sample;

/**
 *  Eurasia Plane Store Extends PlaneStore
 */
public class EurasiaPlaneStore extends PlaneStore{

    /**
     *  initializes own ingredient factory
     */
    public EurasiaPlaneStore(){
        ingredientFactory = new EurasiaIngredientFactory();
    }

}
