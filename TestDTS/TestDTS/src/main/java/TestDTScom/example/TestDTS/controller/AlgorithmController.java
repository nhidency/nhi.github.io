package TestDTScom.example.TestDTS.controller;

import TestDTScom.example.TestDTS.algorithm.*;
import TestDTScom.example.TestDTS.models.Data;
import TestDTScom.example.TestDTS.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:8000")
public class AlgorithmController {
    @Autowired
    DataRepository dataRepository;
    @PostMapping("/mergeSort")
    public String[] mergeSort1(@RequestBody String[] arr) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, 999);
        return arr;
    }

    @PostMapping("/bubbleSort")
    public String[] bubbleSort1(@RequestBody String[] arr) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        return arr;
    }

    @PostMapping("/insertionSort")
    public String[] insertionSort1(@RequestBody String[] arr) {
        InsertSort insertSort = new InsertSort();
        insertSort.insertionSort(arr);
        return arr;
    }

    @PostMapping("/binarySort")
    public String[] binarySort1(@RequestBody String[] arr) {
        BinarySort binarySort = new BinarySort();
        binarySort.binarySort(arr);
        return arr;
    }

    @PostMapping("/quickSort")
    public String[] countingSort1(@RequestBody String[] arr) {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        return arr;
    }
    @PostMapping("/randomString")
    public String[] random() {
        String[] randomStringObjects = new String[1000]; // Khởi tạo mảng với kích thước 1000
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 1000; i++) {
            int length = random.nextInt(5) + 1; // Độ dài ngẫu nhiên từ 1 đến 5
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                int index = random.nextInt(characters.length());
                sb.append(characters.charAt(index));
            }
            String data = sb.toString();
            randomStringObjects[i] = data; // Thêm chuỗi ngẫu nhiên vào mảng
        }
        Data data = new Data();
        data.setValues(List.of(randomStringObjects));
        Data data1 = dataRepository.save(data);
        return data1.getValues().toArray(new String[0]);
    }
}
