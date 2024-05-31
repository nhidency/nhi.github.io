package TestDTScom.example.TestDTS.algorithm;

import java.util.Random;

public class QuickSort {
    public void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        // Chọn pivot ngẫu nhiên
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;
        String pivot = arr[randomIndex];

        // Hoán đổi pivot với phần tử cuối cùng của mảng
        String temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        // Tiến hành partitioning như bình thường
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                String temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }
        }
        String temp3 = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp3;

        return i + 1;
    }
}
