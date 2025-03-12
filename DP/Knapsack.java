import java.util.*;

class Knapsack {
    /* Recursive 0/1 Knapsack Solution */
    private static int knapSack(int capacity, int[] val, int[] wt, int n) {
        if (capacity == 0 || n < 0) {
            return 0;
        }

        if (wt[n] <= capacity) { // Should be `<=`
            int include = val[n] + knapSack(capacity - wt[n], val, wt, n - 1);
            int exclude = knapSack(capacity, val, wt, n - 1);
            return Math.max(include, exclude);
        } else {
            return knapSack(capacity, val, wt, n - 1);
        }
    }
    /*DP (Top-Down) Approach*/
    private static int topToDown(int capacity, int[] val, int[] wt, int[][] dp) {
        int n = val.length;

        for (int i = 1; i <= n; i++) {  // Items
            for (int j = 1; j <= capacity; j++) {  // Capacity
                if (wt[i - 1] <= j) { // Use `<=` to check if item can be included
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity]; // Return the maximum value at full capacity
    }

    public static void knapsackCall(int capacity, int[] val, int[] wt) {
        try {
            int n = val.length;

            /** Recursive solution */
            int ans = knapSack(capacity, val, wt, n - 1);

            /** DP solution */
            /** Initialize DP table with zero */
            int[][] dp = new int[n + 1][capacity + 1];
            int ans2 = topToDown(capacity, val, wt, dp);

            System.out.println("Maximum value (Recursive): " + ans);
            System.out.println("Maximum value (DP): " + ans2);
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* Subset sum Recursive*/
    private static boolean subset(int[] val, int capacity, int n) {
        /** base condition **/
        if(capacity == 0) {
            return true;
        }
        if(capacity < 0 || n < 0) {
            return false;
        }

        if(val[n] <= capacity) {
            return subset(val, capacity - val[n], n - 1) || subset(val, capacity, n - 1);
        } else {
            return subset(val, capacity, n - 1);
        }
    }
    /** Subset Memoization **/
    private static boolean subsetMemoization(int[] val, int[][] dp, int capacity, int n) {
        /** base case **/

    }
    public static void subsetCall(int capacity, int[] val) {
        try {
            int n = val.length;
            /**Recusive solution*/
            boolean res = subset(val, capacity, n - 1);
            System.out.println("Subset preasent (Recursive): " + res);

            /** Memoization **/
            Boolean[][] dp = new Boolean[val.length + 1][n + 1];
            for(int i = 0; i <= nums.length; i++) {
                dp[i][0] = true;
            }

        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        try {
            int profit[] = new int[] { 60, 100, 120, 50 };
            int weight[] = new int[] { 10, 20, 30, 25 };
            int W = 50;
//            knapsackCall(W, profit, weight);

            subsetCall(W, profit);
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
}
