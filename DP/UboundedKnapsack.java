class UboundedKnapsack {
    /*Given a rod of length n(size of price) inches and an array of prices, price. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.*/
    private static int rodCutRecusion(int[] price, int size, int idx) {
        if(idx <= 0 || size == 0) {
            return 0;
        }
        if(idx <= size) {
            int take = price[idx - 1] + rodCutRecusion(price, size - idx, idx);
            int skip = rodCutRecusion(price, size, idx - 1);
            return Math.max(take, skip);
        } else {
            return rodCutRecusion(price, size, idx - 1);
        }

    }
    public static void main(String[] args) {
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum value (Recursive): " + rodCutRecusion(price, 8, 8));
    }
}