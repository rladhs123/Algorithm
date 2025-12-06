package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2711 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int error = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            sb.append(s.substring(0, error - 1)).append(s.substring(error, s.length())).append('\n');
        }

        System.out.print(sb);
    }
}
