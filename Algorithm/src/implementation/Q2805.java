package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int high = 0;
        int low = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > high) {
                high = arr[i];
            }
        }

        int mid = (high + low) / 2;
        int maxH = -1;

        while (low <= high) {
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.max(0, arr[i] - mid);
            }

            if (sum >= m) {
                maxH = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (high + low) / 2;
        }

        System.out.println(maxH);
    }
}
