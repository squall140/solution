package org.ex.leetcode.array.removeelement027;

/**
 * @desc: 快慢指针
 * @author: Leif
 * @date: 2024/3/12 11:09
 */
public class Ex01 {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while ( fast < n){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public static void main(String[] args) {
        //case2
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int val = 2;
        int[] nums = new int[]{3,2,2,3};
        int val = 3;

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);
//        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
