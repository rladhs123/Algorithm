package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }

        int index = 0;

        for (int i = 0; i < 3; i++) {
            if (!arr[i].equals("Fizz") && !arr[i].equals("FizzBuzz") && !arr[i].equals("Buzz")) {
                index = i;
            }
        }

        int x = Integer.parseInt(arr[index]) + arr.length - index;

        if (x % 3 == 0 && x % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (x % 3 == 0) {
            System.out.println("Fizz");
        } else if (x % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(x);
        }
    }
}
