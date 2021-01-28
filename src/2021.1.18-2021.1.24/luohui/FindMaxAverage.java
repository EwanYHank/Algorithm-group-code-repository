package leetcodeTest;

/**
 * leetcode: 643
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0;i < k; i++){
            sum += nums[i];
        }
        double tem = sum;
        for(int i = 1;i < nums.length - k + 1;i++){
            // 前去前一个i-1元素 加上新增的 i+k-1 个元素
            tem = tem - nums[i - 1] + nums[ i + k - 1];
            sum = Math.max(sum,tem);
        }
        double result = sum/k;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double result = FindMaxAverage.findMaxAverage(nums, k);
        System.out.println(result);
    }

}
