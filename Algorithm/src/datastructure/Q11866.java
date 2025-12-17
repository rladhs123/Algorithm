package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int prev = 0;
        int x = n;

        for (int i = 0; i < n; i++) {
            arr[i] = list.remove((prev + k - 1) % x);
            prev = (prev + k - 1) % x;
            x--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                sb.append(arr[i]).append('>');
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        System.out.println(sb);
    }
}
