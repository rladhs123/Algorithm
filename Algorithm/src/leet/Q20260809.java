package leet;

import java.util.Arrays;

public class Q20260809 {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int result = 0;

        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }

        return result;
    }
}
