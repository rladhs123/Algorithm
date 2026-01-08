package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            arr[c - 'a']++;
        }

        boolean check = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5) {
                check = true;
                char result = (char) (i + 'a');
                sb.append(result);
            }
        }

        if (check) {
            System.out.println(sb);
        } else {
            System.out.println("PREDAJA");
        }
    }
}
