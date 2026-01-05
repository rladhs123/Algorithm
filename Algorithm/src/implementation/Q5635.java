package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5635 {

    static class Student implements Comparable<Student> {
        String name;
        int year, month, day;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Student o) {
            int check = this.year - o.year;

            if (check == 0) {
                check = this.month - o.month;

                if (check == 0) {
                    check = this.day - o.day;
                }
            }

            return check;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, d, m, y);
        }

        Arrays.sort(students);

        System.out.print(students[n - 1].name + "\n" + students[0].name);
    }
}
