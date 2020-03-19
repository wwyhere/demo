package com.wwy.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

public class Test1 {
    public static void main(String[] args) {
        //二分
        int[] arr = new int[]{15, 4, 17, 89, 14, 19, 36, 55, 99};

        selectSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        int search = search(arr, 0, arr.length - 1, 9);
        System.out.println(search);
    }

    private static int search(int[] data, int l, int r, int target) {
        int mid;
        int count = 0;
        while (l < r) {
            count++;
            mid = (l + r) / 2;
            if (data[mid] == target) {
                System.out.println("count:" + count);
                return mid;
            } else if (data[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println("count:" + count);
        return -1;
    }

    private static void selectSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }
}
