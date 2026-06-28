package leet;

public class Q20260628 {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] arr = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;

            if (arr[nums[i]] == 2) {
                result[0] = nums[i];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
