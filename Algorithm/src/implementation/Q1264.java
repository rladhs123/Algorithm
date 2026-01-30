package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            int count = 0;

            if (s.equals("#")) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = Character.toLowerCase(s.charAt(i));

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count++;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
