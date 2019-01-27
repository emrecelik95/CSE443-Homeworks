package sample;


/**
 *  PlaneFactory class to create planes
 *
 */
public class PlaneFactory {

    /**
     * creates a new plane using type
     * @param type
     * plane model
     * @return
     * plane
     */
    public Plane createPlane(String type){

        Plane plane = orderPlane(type);

        System.out.println("Creating plane for " + plane.getPurpose() + " purpose...");
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();

        System.out.println("Plane is ready!");

        return plane;
    }

    /**
     * generates a new plane using type
     * @param type
     * plane model
     * @return
     * a new plane
     */
    protected Plane orderPlane(String type){
        if(type.equals("TPX 100"))
            return new TPX100Plane();
        else if(type.equals("TPX 200"))
            return new TPX200Plane();
        else if(type.equals("TPX 300"))
            return new TPX300Plane();
        else
            return null;
    }

}