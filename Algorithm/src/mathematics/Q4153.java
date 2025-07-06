package mathematics;

import java.util.Scanner;

public class Q4153 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] array = new int[3];
            int max = -1;

            for (int i = 0; i < 3; i++) {
                array[i] = sc.nextInt();
                max = Math.max(max, array[i]);
            }

            if (max == 0) {
                return;
            }

            int squareSum = 0;

            for (int i = 0; i < 3; i++) {
                if (array[i] != max) {
                    squareSum += array[i] * array[i];
                } else {
                    max *= max;
                }
            }

            if (squareSum == max) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
