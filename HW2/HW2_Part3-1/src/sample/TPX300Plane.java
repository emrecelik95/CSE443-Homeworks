package sample;

/**
 *  TPX300 model plane
 */
public class TPX300Plane extends Plane {

    /**
     *  assigns data fields so that
     *  base class uses them during simulating logs.
     *
     */
    public TPX300Plane(){

        purpose = "Transatlantic flights";
        skeleton = "Titanium alloy";
        engine = "Quadro jet engine";
        seating = 250;

    }

}
