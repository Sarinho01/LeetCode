package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int nNumber;
        for (int i = 0; i < nums.length; i++) {
            nNumber = target - nums[i];
            if (numsMap.containsKey(nNumber)) return new int[]{i, numsMap.get(nNumber)};
            numsMap.put(nums[i], i);
        }
        return null;
    }
}
