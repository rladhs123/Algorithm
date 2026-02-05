package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int x = n % b;
            n /= b;

            if (x >= 10) {
                sb.append((char) (x - 10 + 'A'));
            } else {
                sb.append(x);
            }
        }

        sb.reverse();
        System.out.println(sb);
    }
}
