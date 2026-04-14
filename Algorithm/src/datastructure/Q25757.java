package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set.add(s);
        }

        int memberSize = set.size();

        if (c == 'Y') {
            System.out.println(memberSize);
        } else if (c == 'F') {
            System.out.println(memberSize / 2);
        } else {
            System.out.println(memberSize / 3);
        }
    }
}
