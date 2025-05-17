package string;

import java.util.Scanner;

public class Q1748 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int length = 0;
        int start = 1;
        int digit = 1;

        while (start <= N) {
            int end = Math.min(N, start * 10 - 1);
            length += (end - start + 1) * digit;
            start *= 10;
            digit++;
        }

        System.out.println(length);
    }
}
