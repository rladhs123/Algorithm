package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new HashSet<>();

        for (int i = 0; i < sizeA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }


        st = new StringTokenizer(br.readLine());
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < sizeB; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        for (Integer i : setA) {
            if (!setB.contains(i)) {
                result++;
            }
        }

        for (Integer i : setB) {
            if (!setA.contains(i)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
