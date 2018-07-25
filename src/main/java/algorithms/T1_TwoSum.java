package algorithms;

/**
 * 第一题
 *
 * @auther Nova wangxingchen
 * @create 18/4/8
 */
public class T1_TwoSum {
    public static void main(String[] args) {
        int nums[] = {2, 5, 5, 11};
        int target = 10;
        T1_TwoSum t1TwoSum = new T1_TwoSum();
        int[] ints = t1TwoSum.twoSum(nums, target);
        System.out.println(ints[0] + " " + ints[1]);

    }

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
}
