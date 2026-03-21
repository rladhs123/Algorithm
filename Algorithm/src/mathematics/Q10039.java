package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10039 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x < 40) {
                x = 40;
            }

            sum += x;
        }

        System.out.println(sum / 5);
    }
}
