package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(B);
        Arrays.sort(A);

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += A[i] * B[N - i - 1];
        }

        System.out.println(result);
    }
}
