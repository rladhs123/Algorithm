package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q25325 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = st.countTokens();

            for (int j = 0; j < count; j++) {
                String name = st.nextToken();
                map.put(name, map.get(name) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            int x = Integer.compare(b.getValue(), a.getValue());

            if (x != 0) {
                return x;
            }

            return a.getKey().compareTo(b.getKey());
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append(' ').append(e.getValue()).append('\n');
        }

        System.out.print(sb);
    }
}
