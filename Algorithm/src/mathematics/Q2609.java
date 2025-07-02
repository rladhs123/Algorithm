package mathematics;

import java.util.Scanner;

public class Q2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        int lcm = (a * b) / gcd;

        sb.append(gcd).append('\n').append(lcm);
        System.out.println(sb);
    }
}
