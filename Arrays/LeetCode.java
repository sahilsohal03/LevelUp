package Arrays;
import java.util.*;

public class LeetCode {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int count = 0;
        boolean flag = false;
        for (int row[] : pieces) {
            for (int val : row) {
                flag = false;
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] == val) {
                        count++;
                        flag = true;
                    }
            }
            if (count == arr.length)
                return false;
            count = 0;
        }
        return flag;
    }
    /** 41. First Missing Positive */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        return optimisedApproch(nums, n);
    }
     /* Approch 1 O(n^2) */
    public static int bruteforce(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            int check = i + 1;
            boolean flag = false;
            for(int j = 0; j < n; j++) {
                flag = nums[j] == check;
                if(flag) {
                    break;
                }
            }
            if(!flag) {
                return i + 1;
            }
        }
        return n == 1 ? nums[0] + 1 : n + 1;
    }
    /** TC = O(nlogn) */
    public static int firstMissingPositiveSorting(int[] nums, int n) {
        Arrays.sort(nums);
        int res = 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] == res) {
                res++;
            } else if(nums[i] > res) {
                break;
            }
        }
        return res;
    }
    /** TC = O(n) & SC = O(n) */
    public static int firstMissingPositiveVisted(int[] nums, int n) {
        boolean[] visted = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0 && nums[i] <= n) {
                visted[nums[i] - 1] = true;
            }
        }
        for(int i = 1; i <= n; i++) {
            if(!visted[i - 1]) {
                return i;
            }
        }
        return n + 1;
    }
    /** TC = O(n) */
    public static int optimisedApproch(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for(int i = 1; i <= n; i++) {
            if(i != nums[i - 1]) {
                return i;
            }
        }
        return n + 1;
    }
    /** End */
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
    }
}
