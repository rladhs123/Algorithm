package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3028 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[3];
        arr[0] = 1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == 'A') {
                int tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            } else if (c == 'B') {
                int tmp = arr[1];
                arr[1] = arr[2];
                arr[2] = tmp;
            } else {
                int tmp = arr[0];
                arr[0] = arr[2];
                arr[2] = tmp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
