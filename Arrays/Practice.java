package Arrays;
import java.util.*;

class Practice {
    //Indexes of Subarray Sum
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0, end = 0, sum = 0, n = arr.length;

        while(end < n) {
            sum += arr[end];

            while(sum > target && start < end) {
                sum -= arr[start++];
            }
            if(target == sum) {
                ans.add(start + 1);
                ans.add(end + 1);
                return ans;
            }
            end++;
        }
        ans.add(-1);
        return ans;
    }
    // Function to find maximum product subarray
    static public int maxProduct(int[] nums) {
        int n = nums.length, maxProd = 1, ans = -(int)1e9;

        for(int i = 0; i < n; i++) {
            maxProd *= nums[i];
            ans = Math.max(ans, maxProd);

            if(nums[i] == 0) {
                maxProd = 1;
            }
        }
        maxProd = 1;
        for(int i = n - 1; i >= 0; i--) {
            maxProd *= nums[i];
            ans = Math.max(ans, maxProd);

            if(nums[i] == 0) {
                maxProd = 1;
            }
        }
        return ans;
    }
    /** Product of Array Except Self **/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prrfix[] = new int[n];
        prrfix[0] = 1;

        for(int i = 1; i < n; i++) {
            prrfix[i] = prrfix[i - 1] * nums[i - 1];
        }
        int suffixProd = 1;
        for(int sufix = n - 1; sufix >= 0; sufix--) {
            prrfix[sufix] *= suffixProd;
            suffixProd *= nums[sufix];
        }
        return prrfix;
    }
    /**  [2,0,2,1,1,0] **/
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;

        while(mid <= end) {
            if(nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }
    /** Container With Most Water **/
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1; // last building

        int maxWater = 0;
        while(left <= right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;

            maxWater = Math.max(maxWater, h * w);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    /** Rotate Array **/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k > 0) {
            k = k % nums.length;
            helper(nums, 0, n - k - 1);
            helper(nums, n - k, n - 1);
            helper(nums, 0, n - 1);
        }
    }
    private void helper(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /** Missing And Repeating **/
     static void ArrayList<Integer> findTwoElement(int arr[]) {
            ArrayList<Integer> ans = new ArrayList<>();
            int map[] = new int[(int)1e6];

            for(int val: arr) {
                map[val]++;
            }

            int missingNumber = 1, repeatedNumber = -1, i = 0;
            boolean flag = false;

            while(i < arr.length) {
                if(map[arr[i]] > 1) {
                    repeatedNumber = arr[i];
                }
                if(map[missingNumber] != 0) {
                    missingNumber+=1;
                } else {
                    flag = true;
                }

                if(flag && repeatedNumber != -1) {
                    ans.add(repeatedNumber);
                    ans.add(missingNumber);
                    break;
                }
                i++;
            }
            return ans;
        }
    }

    /** 73. Set Matrix Zeroes **/
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> isTosetZero = new ArrayList<>();
        for(int i = 0; i < m * n; i++) {
            if(matrix[i / n][i % n] == 0) {
                isTosetZero.add(i);
            }
        }
        for(int idx : isTosetZero) {
            helper(matrix, idx);
        }
    }
    private void helper(int[][] matrix, int idx) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = idx / n, c = idx % n;

        for(int i = 0; i < n; i++) {
            matrix[r][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            matrix[i][c] = 0;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 15};
        int target = 15;
        boolean result = subarraySum(arr, target);
        System.out.println(result);
    }
}