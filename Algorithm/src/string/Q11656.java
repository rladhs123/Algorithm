package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i, s.length());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (String string : arr) {
            sb.append(string).append('\n');
        }

        System.out.print(sb);
    }
}
