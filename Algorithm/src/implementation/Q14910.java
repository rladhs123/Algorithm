package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        boolean check = false;

        for (int i = 1; i < arr.length; i++) {
            if (Integer.parseInt(arr[i - 1]) > Integer.parseInt(arr[i])) {
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("Bad");
        } else {
            System.out.println("Good");
        }
    }
}
