package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12605 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            String[] strings = br.readLine().split(" ");
            sb.append("Case #").append(i).append(": ");

            for (int j = strings.length - 1; j >= 0; j--) {
                sb.append(strings[j]).append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
