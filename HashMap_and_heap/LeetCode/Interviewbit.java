package HashMap_and_heap.LeetCode;

import java.util.*;
import java.lang.Character;
public class Interviewbit {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // ...252 Meeting Room
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0)
            return true;
        // Write your code here
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < pq.peek())
                return false;
            else
                pq.poll();

            pq.add(intervals.get(i).end);
        }
        return true;
    }

    // .... 253 Meeting rooms Leetcode and Interviewbit ->
    // amazon,apple,flipkart,microsoft,ajio,fab [I.M]
    public int solve(int[][] A) {
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            // Compare values according to columns
            public int compare(final int[] entry1, final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        }); // End of f);
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(A[0][1]);
        for (int i = 1; i < A.length; i++) {
            if (A[i][0] < pq.peek())
                count++;
            else
                pq.poll();

            pq.add(A[i][1]);
        }
        return count;
    }

    // 15. 3Sum (imp)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0 || nums[0] == 0)
            Collections.emptyList();
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int Left = i + 1;
            int Right = len - 1;
            int RemainingTargetSum = 0 - nums[i];
            while (Left < Right) {
                int two_sum = nums[Left] + nums[Right];
                if (two_sum < RemainingTargetSum)
                    Left++;
                else if (two_sum > RemainingTargetSum)
                    Right--;
                else {
                    List<Integer> arr2 = new ArrayList<>();
                    arr2.add(nums[i]);
                    arr2.add(nums[Left]);
                    arr2.add(nums[Right]);
                    arr.add(arr2);
                    while (Left < Right && nums[Left] == arr2.get(1))
                        ++Left;
                    while (Left < Right && nums[Right] == arr2.get(2))
                        --Right;
                }
            }
            while (i + 1 < len && nums[i + 1] == nums[i])
                ++i;
        }
        return arr;
    }

    // Important Interview Prespective
    // 18. 4Sum T.C -> (nlon(n) + n^2log(n))
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        if (nums.length < 4)
            Collections.emptyList();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int mid = j + 1;
                int high = nums.length - 1;

                while (mid < high) {
                    int sum = nums[i] + nums[j] + nums[mid] + nums[high];
                    if (sum == target) {
                        List<Integer> arr2 = new ArrayList<>();
                        arr2.add(nums[i]);
                        arr2.add(nums[j]);
                        arr2.add(nums[mid]);
                        arr2.add(nums[high]);
                        set.add(arr2);
                    }
                    if (sum < target)
                        mid++;
                    else
                        high--;
                }
            }

        }
        // return new ArrayList(set);
        return Collections.emptyList();
    }

    // Optimiztion T.C (nlog(n) + n^3)
    public List<List<Integer>> fourSum_optimization(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len < 4)
            return Collections.emptyList();
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int Left = j + 1;
                int Right = len - 1;
                int left_target_sum = target - nums[i] + nums[j];

                while (Left < Right) {
                    int two_sum = nums[Left] + nums[Right];
                    if (two_sum < left_target_sum)
                        Left++;
                    else if (two_sum > left_target_sum)
                        Right--;
                    else {
                        List<Integer> arr2 = new ArrayList<>();
                        if (left_target_sum + two_sum == target) {
                            arr2.add(nums[i]);
                            arr2.add(nums[j]);
                            arr2.add(nums[Left]);
                            arr2.add(nums[Right]);
                            arr.add(arr2);
                        }
                        while (Left < Right && nums[Left] == arr2.get(2))
                            ++Left;
                        while (Left < Right && nums[Right] == arr2.get(3))
                            --Right;
                    }
                }
                while (i + 1 < len && nums[i + 1] == nums[i])
                    ++i;
                while (j + 1 < len && nums[j + 1] == nums[j])
                    ++j;
            }
        }

        return arr;
    }

    // 454. 4Sum II
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int numA : A) {
            for (int numB : B) {
                int sumAB = numA + numB;
                hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
            }
        }
        for (int numC : C) {
            for (int numD : D) {
                int sumCD = numC + numD;
                count += hashMap.getOrDefault(-sumCD, 0);
            }
        }
        return count;
    }

    /// 205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (l1 != l2)
            return false;

        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        int i = 0;
        while (i < l1) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            Character cc = new Character(c1);
            if (hm.containsKey(cc) == true) {
                if (hm.get(cc) != c2)
                    return false;

            } else {
                if (set.contains(c2))
                    return false;
                hm.put(c1, c2);
                set.add(c2);
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}


