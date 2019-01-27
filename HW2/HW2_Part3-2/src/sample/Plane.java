package sample;

/**
 *  Abstract Class For Planes
 */
public abstract class Plane {

    /**
     *  Flight Purpose
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
     *  Engine Injection Type
     */
    protected String engineInjectionType;
    /**
     *  Seating Cover
     */
    protected String seatingCover;

    /**
     *   Construct skeleton message.
     *   Uses skeleton member
      */
    public void constructSkeleton(){
        System.out.println("Construction skeleton as " + skeleton + "...");
    }

    /**
     *  Place engines message.
     *  Uses engine and engineInjectionType members
     */
    public void placeEngines(){
        System.out.println("Placing " + engine + ", Engine Injection Type : " + engineInjectionType + "...");
    }

    /**
     *  Place seats message.
     *  Uses seating and seatingCover members.
     */
    public void placeSeats(){
        System.out.println("Placing " + seating + " " + seatingCover + " Seats...");
    }

    /**
     * purpose getter
     * @return
     * purpose
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
     * seating getter
     * @return
     * seating
     */
    public int getSeating() {
        return seating;
    }
}

