package leet;

public class Q20260827 {

    public int[] leftRightDifference(int[] nums) {
        int size = nums.length;
        int[] leftSum = new int[size];
        int[] rightSum = new int[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            leftSum[i] = sum;
            sum += nums[i];
        }

        sum = 0;

        for (int i = size - 1; i >= 0; i--) {
            rightSum[i] = sum;
            sum += nums[i];
        }

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}
