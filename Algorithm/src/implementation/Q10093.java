package implementation;

import java.util.Scanner;

public class Q10093 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        StringBuilder sb = new StringBuilder();
        long count = max - min - 1;

        if (count < 0) {
            count = 0;
        }

        sb.append(count).append('\n');

        for (long i = min + 1; i < max; i++) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
