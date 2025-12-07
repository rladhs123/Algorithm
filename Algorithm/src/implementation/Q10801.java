package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10801 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[10];
        int[] b = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            b[i] = Integer.parseInt(st.nextToken());

            if (a[i] > b[i]) {
                scoreA++;
            } else if (b[i] > a[i]){
                scoreB++;
            }
        }

        if (scoreA > scoreB) {
            System.out.println("A");
        } else if (scoreB > scoreA) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }
    }
}
