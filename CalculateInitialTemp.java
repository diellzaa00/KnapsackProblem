package ai;

import java.util.*;

/** Many methods have been proposed in literature to compute the initial temperature T0.Itis suggested in Kirkpatrick et al. [10] to take
 *  T0=(delta)Emax where (delta)Emax is the maximal cost difference between any two neighboring solutions*/
public class CalculateInitialTemp {
	public int[] calculateTotalValueAndSize(int[] packing, int[] values, int[] sizes, int max_size) {
        double totalValue = 0.0;
        double totalSize = 0.0;

        for (int i = 0; i < packing.length; i++) {
            if (packing[i] == 1) {
                totalValue += values[i];
                totalSize += sizes[i];
            }
        }
        /**
        if (totalSize > max_size) {
            totalValue = 0.0;
        }
        */

        return new int[]{(int) totalValue, (int) totalSize};
    }
	
	public double calculateIntitialTemp(int[] values, int[] sizes, int max_size) {
		Adjacent a = new Adjacent();
		Random random = new Random();
		CalculateInitialTemp t = new CalculateInitialTemp();
		ArrayList<Integer> curr_packing = new ArrayList<Integer>();
		int size = values.length;
    	for (int i = 0; i < size; i++) {
    		curr_packing.add(1);
    	}
    	int finalDistance = 0;
    	ArrayList<Integer> neighbor1 = new ArrayList<Integer>();
    	for (int i = 0; i < size; i++) {
    		neighbor1.add(1);
    	}
    	for (int i = 0; i < size; i++) {
    		
    		ArrayList<Integer> neighbor2 = curr_packing;
    		
    		neighbor2.set(i, 0);
    		for (int j = 0; j < size; j++) {
    			if (j != i) {
    				neighbor2.set(j, 1);
    			}
    		}
    	
    		int[] firstNeighbor = new int[size];
    		int[] secondNeighbor = new int[size];
    		 for (int j = 0; j < neighbor1.size(); j++) {
    	            firstNeighbor[j] = neighbor1.get(j);
    	            secondNeighbor[j] = neighbor2.get(j);
    	       }
    		int[] valuefirst = t.calculateTotalValueAndSize(firstNeighbor, values, sizes, max_size);
    		int[] valuesecond = t.calculateTotalValueAndSize(secondNeighbor, values, sizes, max_size);
    		int value1 = valuefirst[0];
        	int value2 = valuesecond[0];
        	int distance = Math.abs(value1 - value2);
        	if (distance > finalDistance) {
        		finalDistance = distance;
        	} 	
    	}
    	return finalDistance;
    	
	}
	
	public static void main(String[] args) {
		CalculateInitialTemp t = new CalculateInitialTemp();
		Random ra = new Random();
		/**
		 int[] values = {79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
	      int[] sizes =  {85, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34};
	        int max_size = 300;
	        */
	        int[] values = {79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 4242, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 
	        		5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 425, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 4218, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
	        int[] sizes = {85, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42
	        		,5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 4255, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 5, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
	        int max_size = 2000;
		double temp = t.calculateIntitialTemp(values, sizes, max_size);
		/**for (int i = 0; i < values.length; i++) {
			System.out.print(ra.nextInt(100) + ", ");
		}*/
		System.out.println(temp);
	}
}
