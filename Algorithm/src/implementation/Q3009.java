package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arrayX = new int[1001];
        int[] arrayY = new int[1001];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayX[x]++;
            arrayY[y]++;
        }

        int resultX = 0;
        int resultY = 0;

        for (int i = 1; i < 1001; i++) {
            if (arrayX[i] == 1) {
                resultX = i;
            }

            if (arrayY[i] == 1) {
                resultY = i;
            }
        }

        System.out.println(resultX + " " + resultY);
    }
}
