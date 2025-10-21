package implementation;

import java.util.Scanner;

public class Q13300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] array = new int[6][2];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int grade = sc.nextInt();

            array[grade - 1][s]++;
        }

        int result = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (array[i][j] % k == 0) {
                    result += array[i][j] / k;
                } else {
                    result += array[i][j] / k + 1;
                }
            }
        }

        System.out.println(result);
    }
}
