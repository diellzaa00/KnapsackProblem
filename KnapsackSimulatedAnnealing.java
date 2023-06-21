package ai;

import java.util.Arrays;
import java.util.Random;


public class KnapsackSimulatedAnnealing {
    private static final int MAX_ITER = 1000;
    private static final double START_TEMPERATURE = 5000.0;
    private static final double ALPHA = 0.98;

    public static void main(String[] args) {
        CalculateTotalValueAndSize c = new CalculateTotalValueAndSize();
        Solve s = new Solve();
        //TEST 1  
        int[] values = {79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
        int[] sizes =  {85, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34};
        int max_size = 300;
        
        
        /**Test 2
        int[] values = {79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 4242, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 
        		5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 425, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 4218, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
        int[] sizes = {85, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42
        		,5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 4255, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
        int max_size = 2000;
        */
        
     /**TEST 3
        int[] values = new int[10000];
        int[] sizes = new int[10000];
        for(int i = 0; i < 10000; i++) {
        	Random r = new Random();
        	values[i] = r.nextInt(100);
        	sizes[i] = r.nextInt(100);
        }
        
        int max_size = 3000;
	*/
        
        /** TEST 4
         int[] values = {53, 3, 11, 62, 4, 9, 60, 3, 69, 53, 76, 24, 4, 12, 8, 80, 41, 23, 49, 76, 22, 81, 19, 38, 51, 13, 62, 56, 59, 54, 41, 85, 60, 52, 27, 69, 28, 97, 91, 31, 66, 36, 41, 63, 4, 85, 44, 38, 67, 53, 31, 67, 41, 6, 94, 40, 8, 84, 6, 34, 35, 83, 73, 18, 82, 25, 25, 66, 27, 11, 85, 55, 79, 8, 89, 13, 69, 50, 18, 40, 77, 62, 57, 18, 22, 38, 6, 4, 82, 62, 55, 86, 49, 29, 67, 99, 78, 54, 61, 68};
         int[] sizes  = {43, 67, 45, 75, 24, 48, 31, 65, 27, 77, 93, 28, 60, 24, 48, 71, 71, 17, 74, 73, 63, 87, 21, 12, 62, 85, 58, 85, 19, 56, 99, 22, 92, 73, 38, 12, 12, 25, 16, 22, 60, 62, 99, 75, 35, 62, 13, 76, 0, 54, 97, 6, 97, 36, 83, 70, 18, 74, 64, 48, 75, 50, 44, 54, 98, 52, 69, 73, 29, 83, 45, 19, 12, 60, 8, 7, 20, 94, 19, 7, 45, 47, 65, 52, 93, 76, 12, 55, 34, 82, 24, 89, 1, 89, 9, 25, 66, 91, 38, 78};
         int max_size = 200;
         */
        System.out.println("Item values:");
        System.out.println(Arrays.toString(values));
        System.out.println("Item sizes:");
        System.out.println(Arrays.toString(sizes));
        System.out.println("Max total size = " + max_size);

        Random rnd = new Random();
        int[] packing = s.solve(values.length, rnd, values, sizes, max_size, MAX_ITER, START_TEMPERATURE, ALPHA);

        System.out.println("\nBest packing found:");
        System.out.println(Arrays.toString(packing));

        int[] result = c.calculateTotalValueAndSize(packing, values, sizes, max_size);
        double totalValue = result[0];
        double totalSize = result[1];

        System.out.println("\nTotal value of packing = " + totalValue);
        System.out.println("Total size of packing = " + totalSize);

    }



}

