package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            arr[x]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
