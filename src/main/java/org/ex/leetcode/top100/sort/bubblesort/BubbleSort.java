package org.ex.leetcode.top100.sort.bubblesort;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/7 15:55
 */
public class BubbleSort {
    public static void BubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[i]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 90, 1, 50};
        BubbleSort(arr);
        for(int x : arr){
            System.out.print(x + ", ");
        }
    }
}
