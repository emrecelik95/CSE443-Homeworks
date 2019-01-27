package sample;

/**
 *  Abstract Class for Planes
 */
public abstract class Plane {

    /**
     *  Purpose of the flight
     */
    protected String purpose;
    /**
     *  Skeleton model
     */
    protected String skeleton;
    /**
     *  Engine
     */
    protected String engine;
    /**
     *  Seat Count
     */
    protected int seating;

    /**
     *  Construct message using skeleton member
     */
    public void constructSkeleton(){
        System.out.println("Construction skeleton as " + skeleton + "...");
    }

    /**
     *  Place engines message using engine member
     */
    public void placeEngines(){
        System.out.println("Placing " + engine + "...");
    }

    /**
     *  Place seats message using seating member
     */
    public void placeSeats(){
        System.out.println("Placing " + seating + " Seats...");
    }

    /**
     * purpose getter
     * @return
     *  purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * skeleton getter
     * @return
     * skeleton
     */
    public String getSkeleton() {
        return skeleton;
    }

    /**
     * engine getter
     * @return
     * engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     * seating setter
     * @return
     * seat count
     */
    public int getSeating() {
        return seating;
    }
}

