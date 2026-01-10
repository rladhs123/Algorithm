package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1526 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = n; i >= 4; i--) {
            String s = Integer.toString(i);
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                int x = s.charAt(j) - '0';
                if (x != 4 && x != 7) {
                    continue;
                }

                count++;
            }

            if (count == s.length()) {
                System.out.println(i);
                break;
            }
        }
    }
}
