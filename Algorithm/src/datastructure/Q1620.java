package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] indexToName = new String[n + 1];
        Map<String, Integer> nameToIndex = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            indexToName[i] = input;
            nameToIndex.put(input, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            char c = s.charAt(0);

            if (c >= '0' && c <= '9') {
                sb.append(indexToName[Integer.parseInt(s)]);
            } else {
                sb.append(nameToIndex.get(s));
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
