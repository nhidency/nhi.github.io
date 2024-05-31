package TestDTScom.example.TestDTS.algorithm;

public class BubbleSort {
    // Hàm sắp xếp mảng chuỗi bằng Bubble Sort
    public void bubbleSort(String[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Hoán đổi hai phần tử
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có hoán đổi nào trong lần lặp này, mảng đã sắp xếp
            if (!swapped) {
                break;
            }
        }
    }
}
