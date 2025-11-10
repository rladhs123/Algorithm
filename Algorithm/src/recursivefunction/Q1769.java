package recursivefunction;

import java.util.Scanner;

public class Q1769 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] result = recursiveFunction(s, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(result[1]).append('\n');

        if (result[0] % 3 == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        System.out.println(sb);
    }

    static int[] recursiveFunction(String s, int depth) {
        if (s.length() == 1) {
            int n = s.charAt(0) - '0';
            return new int[]{n, depth};
        } else {
            int sum = 0;

            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }

            return recursiveFunction(Integer.toString(sum), depth + 1);
        }
    }
}
