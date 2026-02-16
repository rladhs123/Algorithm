package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (check(a, b, c)) {
                sb.append("Invalid");
            } else {
                if (a == b && b == c) {
                    sb.append("Equilateral");
                } else if (a == b || b == c || a == c) {
                    sb.append("Isosceles");
                } else {
                    sb.append("Scalene");
                }
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    static boolean check(int a, int b, int c) {
        int sum = a + b + c;
        int max = Math.max(a, Math.max(b, c));

        return sum - max <= max;
    }
}
