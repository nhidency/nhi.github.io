package TestDTScom.example.TestDTS.algorithm;

import java.util.Arrays;

public class BinarySort {
    public void binarySort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, key) + 1);
            System.arraycopy(arr, j, arr, j + 1, i - j);
            arr[j] = key;
        }
    }
}
