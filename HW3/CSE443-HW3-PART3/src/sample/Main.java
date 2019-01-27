package sample;


import java.util.Iterator;

/**
 * Main class of application
 */
public class Main {


    public static void main(String[] args) {
        int[][] data = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        SatelliteData satelliteData = new SatelliteData(data);
        Iterator<Integer> iter = satelliteData.getIterator();

        System.out.println("Satellite Data : ");
        for(int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++)
                System.out.print(data[i][j] + " ");
            System.out.println();
        }

        System.out.println("\nIterated Data : ");
        while(iter.hasNext())
            System.out.print(iter.next() + " ");

        System.out.println();
    }
}
