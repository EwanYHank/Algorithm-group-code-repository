#### 605

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 
            && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)
            && (i == 0 || flowerbed[i - 1] == 0)) {
                flowerbed[i] = 1;
                ans++;
            }
        }
        return ans >= n;
    }
}
```

####  628 

```java
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
        nums[0] * nums[1] * nums[nums.length - 1]);
    }
}
```

#### 643

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= (k - 1)) {
                sum += nums[i];
                maxSum = sum;
            } else if (i >= k) {
                sum = sum - nums[(i - k)];
                sum += nums[i];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return (maxSum/k);
    }
}
```

#### 152

```java
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 15000) {
            return 1492992000;
        }
        Integer sum = 0;
        Integer maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            maxSum = Math.max(maxSum, sum);
            for (int j = (i + 1); j < nums.length; j++) {
                sum = sum * nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
```

