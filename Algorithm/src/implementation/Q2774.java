package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2774 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            boolean[] check = new boolean[10];
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                int n = input.charAt(j) - '0';
                check[n] = true;
            }

            int count = 0;

            for (int j = 0; j < check.length; j++) {
                if (check[j]) {
                    count++;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
