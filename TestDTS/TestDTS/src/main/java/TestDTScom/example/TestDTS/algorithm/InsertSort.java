package TestDTScom.example.TestDTS.algorithm;

public class InsertSort {
    public void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            int j = i - 1;

            /* Di chuyển các phần tử của arr[0..i-1], lớn hơn key,
               tới một vị trí trước đó của chúng */
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
