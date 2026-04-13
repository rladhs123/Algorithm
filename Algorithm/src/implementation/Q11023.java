package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int size = st.countTokens();

        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println(sum);
    }
}
