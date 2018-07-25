### 1. Two Sum
```
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```
#### 思路：
初始化一个桶，比如数组a【1,2,7,11】找9， 那么会初始化一个11长度的数组b，对于输入数组12711， 标记 b对应下标为127 11的值分别为0,1,2,3（即在a数组中的下标）。 然后遍历b, 只要一个数和他相对于9的差数都被标记过，比如2,7直接返回两个下标即可。
调试过程中发现了重数{3,3}，负数等情况， 做了一些调整。
复杂度: 时间O(n) 空间O(n)
#### 结果：
9ms  优于75% （cn站成绩是8ms,优于92%  说明总站可能样本什么更全一些，故以后都在总站提交）

我的代码
```
 public int[] twoSum(int[] nums, int target) {
        //找出最值确定堆大小
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }

        String heap[] = new String[max - min + 1];
        for (int i = 0; i < heap.length; i++) {
            heap[i] = "";
        }
        //遍历nums , 初始化堆 存放nums下标i
        for (int i = 0; i < nums.length; i++) {
            if (heap[nums[i] - min] == "") {
                heap[nums[i] - min] = "" + i;
            } else {
                heap[nums[i] - min] = heap[nums[i] - min] + "," + i;
            }
        }

        int result[] = new int[2];
        //遍历堆
        for (int i = 0; i < heap.length; i++) {
            if (heap[i] != "" && (target - i - 2 * min) < heap.length && heap[target - i - 2 * min] != "") {
                if (heap[i].contains(",")) {
                    String[] split = heap[i].split(",");
                    result[0] = Integer.valueOf(split[0]).intValue();
                    result[1] = Integer.valueOf(split[1]).intValue();
                    break;

                } else {
                    result[0] = Integer.valueOf(heap[i]).intValue();
                    result[1] = Integer.valueOf(heap[target - i - 2 * min]).intValue();
                    break;
                }
            }
        }
        return result;
    }
```

### 调优VV1：
我的解法很麻烦，由于要维护桶多做了很多开销。
其实这个所谓的桶可以用hashmap 来替代。

