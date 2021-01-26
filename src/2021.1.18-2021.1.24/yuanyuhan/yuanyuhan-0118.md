198

```java
class Solution {
    public int rob(int[] nums) {
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 0;
        }
        if (numsLen == 1) {
            return nums[0];
        } else if (numsLen == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] arr = new int[numsLen];
        arr[0] = nums[0];
        arr[1] = nums[1];
        int rob;
        for (int i = 2; i < numsLen; i++) {
            if (i <= 2) {
                rob = nums[i] + arr[i - 2];
            } else {
                rob = nums[i] + Math.max(arr[i - 2], arr[i - 3]);
            }
            arr[i] = rob;
        }
        return Math.max(arr[arr.length-1], arr[arr.length - 2]);
    }
    
}
```

209

```java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = nums[start];
        int len = Integer.MAX_VALUE;

        while (true) {
            if (sum < s) {
                if (end < nums.length - 1) {
                    end++;
                    sum += nums[end];
                } else {
                    if (len == Integer.MAX_VALUE) {
                        len = 0;
                    }
                    break;

                }
            } else {
                if (end - start < 0) {
                    break;
                } else if (end - start + 1 < len) {
                    len = end - start + 1;
                }
                if (start == end) {
                    if (end < nums.length - 1) {
                        end++;
                        sum += nums[end];
                        continue;
                    } else {
                        break;
                    }
                }
                sum -= nums[start];
                start++;
            }

        }
        return len;
    }
}
```

