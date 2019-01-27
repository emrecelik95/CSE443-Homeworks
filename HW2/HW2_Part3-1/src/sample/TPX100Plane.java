package sample;

/**
 *  TPX100 model plane
 */
public class TPX100Plane extends Plane {

    /**
     *  assigns data fields so that
     *  base class uses them during simulating logs.
     *
     */
    public TPX100Plane(){

        purpose = "Domestic flights";
        skeleton = "Aluminum alloy";
        engine = "Single jet engine";
        seating = 50;

    }

}
