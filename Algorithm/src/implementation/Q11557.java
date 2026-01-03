package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String maxName = "";
            int maxCount = -1;

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int l = Integer.parseInt(st.nextToken());

                if (l > maxCount) {
                    maxName = name;
                    maxCount = l;
                }
            }

            sb.append(maxName).append('\n');
        }

        System.out.print(sb);
    }
}
