package leet;

public class Q20261117 {

    public int subarraySum(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= Math.max(0, i - nums[i]); j--) {
                result += nums[j];
            }
        }

        return result;
    }
}
