package leet;

public class Q20261120 {

    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;

        for (int num : nums) {
            sum += num;

            String s = Integer.toString(num);

            for (int i = 0; i < s.length(); i++) {
                digitSum += s.charAt(i) - '0';
            }
        }

        int result = Math.abs(sum - digitSum);

        return result;
    }
}
