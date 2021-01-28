package leetcodeTest;

/**
 * leetcode: 209
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 思路：
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == s ? 1 : 0;
        }
        int minWidth = nums.length+1;
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = 0;

        while (rightIndex < nums.length){
            // 当和小于s时，左边固定，右边移动，
            for (; rightIndex < nums.length && sum < s; rightIndex++) {
                sum += nums[rightIndex];
            }
            // 当和大于s时，右边固定，左边移动，
            while (sum >= s) {
                // 宽度是右坐标-左坐标
                minWidth = Math.min(minWidth, rightIndex - leftIndex);
                sum = sum-nums[leftIndex];
                leftIndex++;
            }
        }
        return minWidth == nums.length+1 ? 0: minWidth;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int s = 15;
        int a = MinSubArrayLen.minSubArrayLen(s, nums);
        System.out.println(a);
    }
}
