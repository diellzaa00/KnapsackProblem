package ai;

import java.util.Arrays;
import java.util.Random;

public class Adjacent {
    public static int[] adjacent(int[] packing, Random rnd) {
        int[] result = Arrays.copyOf(packing, packing.length);
        int i = rnd.nextInt(packing.length);

        if (result[i] == 0) {
            result[i] = 1;
        } else if (result[i] == 1) {
            result[i] = 0;
        }

        return result;
    }
}
