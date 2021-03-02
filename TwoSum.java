import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {3,3};
        int[] result = TwoSum.twoSum(nums, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result[] = new int[2];

        for (int i=0; i<nums.length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                return new int[] {map.get(remainder), i};
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
