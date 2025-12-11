package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strings = input.split(",");
        int sum = 0;

        for (int i = 0; i < strings.length; i++) {
            sum += Integer.parseInt(strings[i]);
        }

        System.out.println(sum);
    }
}
