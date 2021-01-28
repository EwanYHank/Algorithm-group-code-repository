package leetcodeTest;

/**
 * leetcode: 152
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 思路：循环数组，当前是正数时，继续*之前的最大值，当现在是负数时，*以之前的最小值
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int result = MaxProduct.maxProduct(nums);
        System.out.println(result);
    }
}
