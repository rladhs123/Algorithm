package implementation;

import java.util.Scanner;

public class Q2846 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int result = 0;
        int start = array[0];
        int prev = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] > prev) {
                prev = array[i];
            } else {
                result = Math.max(result, prev - start);
                start = array[i];
                prev = array[i];
            }
        }

        result = Math.max(result, prev - start);

        System.out.println(result);
    }
}
