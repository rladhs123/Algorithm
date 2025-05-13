package datastructure;

import java.util.*;

/**
 * 베스트셀러
 *
 * 김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다.
 * 김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
 * 오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.
 */
public class Q1320 {

    static int N;

    static class Book implements Comparable<Book>{
        String name;
        int count;

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Book o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        List<Book> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int max = -1;

        for (int i = 0; i < N; i++) {
            String s = sc.next();

            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }

            for (Integer value : map.values()) {
                if (value > max) {
                    max = value;
                }
            }
        }

        for (String string : map.keySet()) {
            if (map.get(string) == max) {
                list.add(new Book(string, map.get(string)));
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0).name);
    }
}
