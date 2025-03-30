package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 비밀번호 찾기
 *
 * 비밀번호를 찾아주는 프로그램을 만들어보자.
 */
public class Q17219 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            map.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            String password = map.get(br.readLine());
            sb.append(password).append('\n');
        }

        System.out.println(sb);
    }
}
