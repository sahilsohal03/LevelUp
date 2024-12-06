package Algorithms;

public class MergeSort {

    /**
     * Merges two contiguous subarrays of the given array into a single sorted segment.
     * The first subarray is arr[si..mid] and the second subarray is arr[mid+1..ei].
     *
     * @param arr          The array containing the subarrays to be merged.
     * @param si           The starting index of the first subarray.
     * @param mid          The ending index of the first subarray, and the midpoint for merging.
     * @param ei           The ending index of the second subarray.
     * @param sortedarray  A temporary array used to assist in merging the two subarrays.
     */
    public static void merge(int[] arr, int si, int mid, int ei, int[] sortedarray) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                sortedarray[k++] = arr[i++];
            } else {
                sortedarray[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            sortedarray[k++] = arr[i++];
        }
        while (j <= ei) {
            sortedarray[k++] = arr[j++];
        }

        k = 0;
        for (int a = si; a <= ei; a++) {
            arr[a] = sortedarray[k++];
        }

    }

    public static void mergeSort(int[] arr, int si, int ei, int[] sortedaray) {
        if (si < ei) {
            int mid = (si + ei) / 2;
            mergeSort(arr, si, mid, sortedaray);
            mergeSort(arr, mid + 1, ei, sortedaray);
            merge(arr, si, mid, ei, sortedaray);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 4, 7, 6, 3, 1, 5, 10 };
        int[] sortedarray = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, sortedarray);
        for (int val : arr)
            System.out.print(val + " ");
    }

}

