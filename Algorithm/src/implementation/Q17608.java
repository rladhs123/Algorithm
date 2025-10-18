package implementation;

import java.util.Scanner;

public class Q17608 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stick = new int[n];

        for (int i = 0; i < n; i++) {
            stick[i] = sc.nextInt();
        }

        int result = 1;
        int lastStickHeight = stick[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (stick[i] > lastStickHeight) {
                result++;
                lastStickHeight = stick[i];
            }
        }

        System.out.println(result);
    }
}
