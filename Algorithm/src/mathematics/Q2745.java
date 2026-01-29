package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2745 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x;

            if (c >= '0' && c <= '9') {
                x = c - '0';
            } else {
                x = c - 'A' + 10;
            }

            result += x * Math.pow(b, s.length() - i - 1);
        }

        System.out.println(result);
    }
}
