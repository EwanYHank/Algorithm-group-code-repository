605

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int m = 0;
        for (int index = 0; index < flowerbed.length; index++) {
            if (isOkay(flowerbed, index)) {
                flowerbed[index] = 1;
                m++;
                index++;
            }
        }
        if (n <= m) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isOkay(int[] flowerbed, int index) {
        int flowerLen = flowerbed.length;
        if (flowerbed[index] == 1) {
            return false;
        } else {
            if (index == 0) {
                if (index + 1 >= flowerLen) {
                    return true;
                } else if (flowerbed[index + 1] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (index == flowerLen-1) {
                if (flowerbed[index-1]==0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (flowerbed[index-1] == 0 && flowerbed[index+1] == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    
}
```

628

```java
class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int negaLen = 0;
        int posiLen = 0;
        int zeroPosition = -1;
        int result;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negaLen++;
            } else if (nums[i] > 0) {
                posiLen++;
            } else {
                zeroPosition = i;
            }
        }
        if (negaLen >= 2) {
            if (posiLen > 0) {
                if (posiLen > 2) {
                    if (nums[0] * nums[1] > nums[len - 2] * nums[len - 3]) {
                        result = nums[0] * nums[1] * nums[len - 1];
                    } else {
                        result = nums[len - 1] * nums[len - 2] * nums[len - 3];
                    }
                } else {
                    result = nums[0] * nums[1] * nums[len - 1];
                }
            } else {
                result = nums[len - 1] * nums[len - 2] * nums[len - 3];
            }
        } else {
            result = nums[len - 1] * nums[len - 2] * nums[len - 3];
        }
        return result;
    
    }
}
```

643

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxSum;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        if (k >= nums.length) {
            return sum/k;
        } else {
            int start = 1;
            int end = k;
            while (end < nums.length) {
                sum = sum - nums[start - 1];
                sum += nums[end];
                if (sum > maxSum) {
                    maxSum = sum;
                }
                start++;
                end++;
            }
        }
        return maxSum/k;
    }
}
```

152

```java
class Solution {
    public int maxProduct(int[] nums) {
       if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int minProduct = Integer.MIN_VALUE;
        int product = nums[start];
        int len = 0;
        boolean getEnd = false;
        while (true) {
            if (end == start || nums[end] == 0 || end == nums.length - 1) {
                if (start == end) {
                    if (end == nums.length - 1) {
                        product = nums[start];
                        if (product > minProduct) {
                            minProduct = product;
                        }
                        break;
                    } else if (nums[end] == 0) {
                        start++;
                        end++;
                        if (0 > minProduct) {
                            minProduct = 0;
                        }
                    } else {
                        product = nums[start];
                        len = 0;
                        if (product > minProduct) {
                            minProduct = product;
                        }
                        end++;
                    }
                    continue;
                }
                if (nums[end] == 0 || end == nums.length - 1) {
                    if (end == nums.length - 1 && !getEnd && nums[end] != 0) {
                        product = product * nums[end];
                        if (product > minProduct) {
                            minProduct = product;
                            len++;
                        }
                        getEnd = true;
                    }
                    if (len > 0) {
                        product = product / nums[start];
                        len--;
                    }
                    if (product > minProduct) {
                        minProduct = product;
                    }
                    start++;
                }

            } else {
                product = product * nums[end];
                len++;
                if (product > minProduct) {
                    minProduct = product;
                }
                end++;
            }
        }
        return minProduct;
    }
}
```

