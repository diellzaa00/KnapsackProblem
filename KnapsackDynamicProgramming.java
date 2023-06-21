package ai;

public class KnapsackDynamicProgramming {
        // A utility function that returns
        // maximum of two integers
        static int max(int a, int b) { return (a > b) ? a : b; }
     
        // Returns the maximum value that
        // can be put in a knapsack of
        // capacity W
        static int knapSack(int W, int wt[], int val[], int n)
        {
            // Base Case
            if (n == 0 || W == 0)
                return 0;
     
            // If weight of the nth item is
            // more than Knapsack capacity W,
            // then this item cannot be included
            // in the optimal solution
            if (wt[n - 1] > W)
                return knapSack(W, wt, val, n - 1);
     
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            else
                return max(val[n - 1]
                               + knapSack(W - wt[n - 1], wt,
                                          val, n - 1),
                           knapSack(W, wt, val, n - 1));
        }
     
        // Driver code
        public static void main(String args[])
        {
        	int[] profit = {79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
            int[] weight = {85, 26, 48, 21, 22, 95, 43, 45, 55, 52, 23, 12, 11, 45, 22, 44, 55, 66, 12, 32, 44, 9, 5, 4, 3, 22, 19, 34, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42, 79, 32, 47, 18, 26, 85, 33, 40, 45, 59, 48, 78, 29, 21, 51, 92, 34, 10, 20, 30, 40, 1, 2, 3, 4, 12, 32, 42};
            int max_size = 300;
            int n = profit.length;
            int W = 300;
            System.out.println(knapSack(W, weight, profit, profit.length));
        }
}

