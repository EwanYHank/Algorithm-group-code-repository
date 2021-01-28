package leetcodeTest;

import java.util.Arrays;

/**
 * leetcode 628
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class ThreeNumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int hasNegativeNum = nums[0]*nums[1]*nums[nums.length-1];
        int allPositiveNum = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        return Math.max(hasNegativeNum, allPositiveNum);
    }
    public static void main(String[] args) {
        int[] nums = {-6,-2,-2,3,4,6};
        int result = ThreeNumProduct.maximumProduct(nums);
        System.out.println(result);
    }
}
