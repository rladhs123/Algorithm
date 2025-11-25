package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q8979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] countries = new int[n][4];
        int targetIndex = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());

                if (countries[i][0] == k) {
                    targetIndex = i;
                }
            }
        }

        int grade = 1;
        int targetGold = countries[targetIndex][1];
        int targetSilver = countries[targetIndex][2];
        int targetCopper = countries[targetIndex][3];

        for (int i = 0; i < n; i++) {
            if (countries[i][1] > targetGold) {
                grade++;
            } else if (countries[i][1] == targetGold) {
                if (countries[i][2] > targetSilver) {
                    grade++;
                } else if (countries[i][2] == targetSilver) {
                    if (countries[i][3] > targetCopper) {
                        grade++;
                    }
                }
            }
        }

        System.out.println(grade);
    }
}
