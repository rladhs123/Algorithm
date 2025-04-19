package sort;

import java.util.*;

/**
 * 나이순 정렬
 * 
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이때, 회원들을 나이가 증가하는 순으로,
 * 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 */
public class Q10814 {

    static int N, age;
    static String name;

    static class Member implements Comparable<Member> {
        int num, age;
        String name;

        public Member(int num, int age, String name) {
            this.num = num;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.num - o.num;
            } else {
                return this.age - o.age;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            age = sc.nextInt();
            name = sc.next();

            list.add(new Member(i, age, name));
        }

        Collections.sort(list);

        for (Member member : list) {
            System.out.println(member.age + " " + member.name);
        }

    }
}
