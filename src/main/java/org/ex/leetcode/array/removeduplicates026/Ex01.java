package org.ex.leetcode.array.removeduplicates026;

/**
 * @desc: 快慢指针
 * @author: Leif
 * @date: 2024/3/12 10:15
 */
public class Ex01 {
    public static int removeDuplicates(int[] nums){
        int slow = 0, fast = 0, n = nums.length;
        fast++;
        while(fast < n ) {
            // {0,0,1,1,1,2,2,3,3,4}
            if (nums[slow] != nums[fast]){
                // TODO: 这里需要先前进一步再用fast的值替换slow的
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;

        }

        return slow + 1;
    }

    public static void main(String[] args) {
        //case2
        int []nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeDuplicates(nums);
        System.out.println(len);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
