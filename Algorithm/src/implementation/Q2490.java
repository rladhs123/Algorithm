package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum == 4) {
                sb.append("E");
            } else if (sum == 3) {
                sb.append("A");
            } else if (sum == 2) {
                sb.append("B");
            } else if (sum == 1) {
                sb.append("C");
            } else {
                sb.append("D");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
