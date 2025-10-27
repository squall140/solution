package org.ex.leetcode.array.twosumiiinputarrayissorted167;

import java.util.Arrays;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/27 13:35
 */
public class Practice02 {
  private static int[] twoSum(int[] numbers, int target ){
    int left = 0 , right = numbers.length - 1;

    while(left < right){
      int sum = numbers[left] + numbers[right];
      if(sum < target) {
        left++;
      }else if( sum > target){
        right--;
      }else{
        return new int[]{left + 1, right + 1};
      }
    }

    return new int[0];

  }

  public static void main(String[] args) {
    int[] numbers = {2, 7, 11, 15};
    int target = 13;
    int[] arr = twoSum(numbers, target);
    Arrays.stream(arr).forEach(System.out::println);
  }
}
