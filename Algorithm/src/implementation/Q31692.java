package implementation;

import java.util.Scanner;

public class Q31692 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int maxStart = -1;

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int time = sc.nextInt();

            if (start + time <= X) {
                if (start > maxStart) {
                    maxStart = start;
                }
            }
        }

        System.out.println(maxStart);
    }
}