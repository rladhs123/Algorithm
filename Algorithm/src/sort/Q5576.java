package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q5576 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = 0, k = 0;

        for (int i = 0; i < 2; i++) {
            int[] array = new int[10];

            for (int j = 0; j < 10; j++) {
                array[j] = sc.nextInt();
            }

            Arrays.sort(array);
            int sum = array[7] + array[8] + array[9];

            if (i == 0) {
                w = sum;
            } else {
                k = sum;
            }
        }

        System.out.println(w + " " + k);
    }
}
