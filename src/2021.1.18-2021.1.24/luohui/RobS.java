package leetcodeTest;

/**
 * leetcode:198
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class RobS {
    public static int rob(int[] nums) {
        // 1. 如果偷第 n 个房屋的话，由于相邻的房屋不能偷，
        // 所以 dp[n] = dp[n - 2] + nums[n]（即等于到第 n - 2 个房屋的最大金额 + 第 n 个房屋的金额）
        // 2. 反之如果不偷第 n 个房屋的话，那么 dp[n] = dp[n - 1]（即等于到第 n - 1 个房屋的最大金额）
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int result = RobS.rob(nums);
        System.out.println(result);
    }

}
