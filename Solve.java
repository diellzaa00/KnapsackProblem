package ai;

import java.util.Arrays;
import java.util.Random;

public class Solve {
    public int[] solve(int n_items, Random rnd, int[] values, int[] sizes, int max_size, int max_iter,
            double start_temperature, double alpha) {
    	CalculateTotalValueAndSize c = new CalculateTotalValueAndSize();
    	Adjacent a = new Adjacent();
    	
    	double curr_temperature = start_temperature;
    	int[] curr_packing = new int[n_items];
    	Arrays.fill(curr_packing, 1);

    	System.out.println("Initial guess:");
    	System.out.println(Arrays.toString(curr_packing));

    	int[] result = c.calculateTotalValueAndSize(curr_packing, values, sizes, max_size);
    	int curr_value = result[0];
    	int curr_size = result[1];

    	int iteration = 0;
    	int interval = max_iter / 40;

    	while (iteration < max_iter) {
    		int[] adj_packing = a.adjacent(curr_packing, rnd);
    		int[] adj_result = c.calculateTotalValueAndSize(adj_packing, values, sizes, max_size);
    		int adj_value = adj_result[0];

    		if (adj_value > curr_value) {
    			curr_packing = adj_packing;
    			curr_value = adj_value;
    		} else {
    			double accept_p = Math.exp((adj_value - curr_value) / curr_temperature);
    			double p = rnd.nextDouble();

    			if (p < accept_p) {
    				curr_packing = adj_packing;
    				curr_value = adj_value;
    			}
    		}

    		if (iteration % 10 == 0) {
    			System.out.printf("iter = %6d : curr value = %7d : curr temp = %10.2f%n",
    					iteration, curr_value, curr_temperature);
    		}

    		if (curr_temperature < 0.00001) {
    			curr_temperature = 0.00001;
    		} else {
    			curr_temperature *= alpha;
    		}

    		iteration++;
    	}

    	return curr_packing;
    }
}
