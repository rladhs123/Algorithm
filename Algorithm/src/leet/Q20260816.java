package leet;

public class Q20260816 {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;

        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                result++;
            }
        }

        return result;
    }
}
