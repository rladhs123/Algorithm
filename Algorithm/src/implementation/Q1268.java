package implementation;

import java.util.Scanner;

public class Q1268 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][5];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n];

            for (int j = 0; j < 5; j++) {
                int x = array[i][j];

                for (int k = 0; k < n; k++) {
                    if (i == k) continue;

                    if (x == array[k][j] && !check[k]) {
                        check[k] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (check[j]) {
                    result[i]++;
                }
            }
        }

        int max = -1;
        int maxStudent = -1;

        for (int i = 0; i < n; i++) {
            if (result[i] > max) {
                max = result[i];
                maxStudent = i + 1;
            }
        }

        System.out.println(maxStudent);
    }
}
