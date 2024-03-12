package org.ex.leetcode.array.movezeroes283;

/**
 * @desc: 快慢指针
 * @author: Leif
 * @date: 2024/3/12 10:44
 */
public class Ex01 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        fast++;
        while ( fast < n ){
            // {0,1,0,3,12}
            // 如果右边的元素不等于0，那么就把右边的元素交换到左边来
            if ( nums[fast] != 0){
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
    }

    public static void main(String[] args) {
        int[] given_num = new int[]{0,1,0,3,12};
        moveZeroes(given_num);
//        Arrays.stream(given_num).forEach(
//                number -> {
//                    System.out.println(number);
//                }
//        );

        for (Integer num : given_num){
            System.out.println(num);
        }



    }
}
