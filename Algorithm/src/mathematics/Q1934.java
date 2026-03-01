package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = 0;

            for (int j = 1; j <= Math.max(a, b); j++) {
                if (a % j == 0 && b % j == 0) {
                    if (j > max) {
                        max = j;
                    }
                }
            }

            sb.append(max * (a / max) * (b / max)).append('\n');
        }

        System.out.print(sb);
    }
}
