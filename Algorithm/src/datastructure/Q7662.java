package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st;
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (x == 1) {
                        int max = map.lastKey();
                        int maxCount = map.get(max);

                        if (maxCount == 1) {
                            map.remove(max);
                        } else {
                            map.put(max, maxCount - 1);
                        }
                    } else {
                        int min = map.firstKey();
                        int minCount = map.get(min);

                        if (minCount == 1) {
                            map.remove(min);
                        } else {
                            map.put(min, minCount - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey());
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}