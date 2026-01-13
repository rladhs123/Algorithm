package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17249 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean left = true;
        boolean right = false;
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left = false;
                right = true;
            }

            if (left && s.charAt(i) == '@') {
                leftCount++;
            }

            if (right && s.charAt(i) == '@') {
                rightCount++;
            }
        }

        System.out.println(leftCount + " " + rightCount);
    }
}
