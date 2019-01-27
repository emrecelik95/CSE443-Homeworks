package sample;

/**
 *  TPX200 model plane
 */
public class TPX200Plane extends Plane{

    /**
     *  assigns data fields so that
     *  base class uses them during simulating logs.
     *
     */
    public TPX200Plane(){

        purpose = "Domestic and short international flights";
        skeleton = "Nickel alloy";
        engine = "Twin jet engine";
        seating = 100;

    }

}
