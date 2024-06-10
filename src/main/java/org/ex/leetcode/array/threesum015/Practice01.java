package org.ex.leetcode.array.threesum015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/10 21:46
 */
public class Practice01 {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return res;
        // Sort
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                // sum
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums ={-1,0,1,2,-1,-4};
//        int[] nums = {0,1,1};
//        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }
}
