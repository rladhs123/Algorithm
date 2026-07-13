package leet;

public class Q20260713 {

    public int minOperations(int[] nums, int k) {
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        return sum % k;
    }
}
