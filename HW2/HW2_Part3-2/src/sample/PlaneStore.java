package sample;

/**
 *  Abstract Class For PlaneStore
 */
public abstract class PlaneStore {

    /**
     *  IngredientFactory Object
     *  Used in orderPlane method
     */
    PlaneIngredientFactory ingredientFactory;

    /**
     * Implemented orderPlane method.
     * Sub-classes doesn't have to override
     * only if they just set IngredientFactory member.
     *
     * @param type
     * Plane model type
     * @return
     * Plane
     */
    protected Plane orderPlane(String type){
        Plane plane = createPlane(type);
        System.out.println("Creating plane for "+plane.getPurpose()+" purpose...");
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();

        System.out.println("Plane is ready!");

        return plane;
    }


    /**
     * Creates a new plane using its type
     * @param type
     * Plane model type
     * @return
     * a new Plane
     */
    public Plane createPlane(String type){
        if(type.equals("TPX 100"))
            return new TPX100Plane(ingredientFactory);
        else if(type.equals("TPX 200"))
            return new TPX200Plane(ingredientFactory);
        else if(type.equals("TPX 300"))
            return new TPX300Plane(ingredientFactory);
        else
            return null;
    }

}