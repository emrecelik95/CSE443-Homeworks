package sample;

import java.util.Iterator;

/**
 *  Satellite Data Class
 *
 */
public class SatelliteData implements Container {

    /**
     *  All data
     */
    protected int[][] data;

    /**
     * Constructor
     * @param data
     * 2d data
     */
    public SatelliteData(int[][] data){
        this.data = data;
    }

    /**
     * iterator getter
     * @return
     * iterator
     */
    public Iterator getIterator(){
        return new SatelliteIterator(data);
    }

    /**
     *  Satellite Iterator that iterates 2d data as spiral.
     */
    private class SatelliteIterator implements Iterator{

        /**
         *  iterated data
         */
        private int[] sData;
        /**
         *  current data index
         */
        private int index = 0;
        /**
         * size of itereated data
         */
        private int length;

        /**
         *  Constructor
         * @param data
         * 2d satellite data
         */
        private SatelliteIterator(int[][] data){
            InitializeSpiralData(data);
        }

        /**
         * takes 2d satellite data and creates spiral iterated data
         * @param data
         * 2d satellite data
         */
        private void InitializeSpiralData(int data[][]){
            int colLeft = 0;
            int colRight = data[0].length - 1;
            int rowUp = 0;
            int rowDown = data.length - 1;
            int c = 0;

            sData = new int[data[0].length * data.length];
            while(colLeft <= colRight && rowUp <= rowDown) {
                for (int i = rowUp; i <= colRight; i++)
                    sData[c++] = data[rowUp][i];
                for(int i = rowUp + 1; i <= rowDown; i++)
                    sData[c++] = data[i][colRight];
                if(rowUp + 1 <= rowDown)
                    for(int i = colRight - 1; i >= colLeft; i--)
                        sData[c++] = data[rowDown][i];
                if(colLeft + 1 <= colRight)
                    for(int i = rowDown - 1; i > rowUp; i--)
                        sData[c++] = data[i][colLeft];

                rowDown--;
                colLeft++;
                rowUp++;
                colRight--;
            }
            length = sData.length;
        }

        /**
         * overrided hasNext
         * @return
         * if index is smaller than length or not
         */
        @Override
        public boolean hasNext() {
            return index < length;
        }

        /**
         * overrided next method
         * @return
         * next number
         */
        @Override
        public Object next() {
            return sData[index++];
        }
    }

}
