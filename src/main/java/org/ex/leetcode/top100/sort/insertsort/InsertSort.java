package org.ex.leetcode.top100.sort.insertsort;

import java.util.Arrays;

/**
 * @desc: Insertion Sort
 * @author: Leif
 * @date: 2024/6/6 22:58
 */
public class InsertSort {

    public static void insertionSort(int[] arr){
        int i, j, key;
        for(i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 90, 1, 50};
        insertionSort(arr);
        for(int x : arr){
            System.out.print(x + ", ");
        }

    }
}
