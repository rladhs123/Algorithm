package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10825 {

    static class Student implements Comparable<Student> {
        String name;
        int koreaScore, englishScore, mathScore;

        public Student(String name, int koreaScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreaScore = koreaScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            int compare = Integer.compare(o.koreaScore, this.koreaScore);
            if (compare != 0) {
                return compare;
            }

            compare = Integer.compare(this.englishScore, o.englishScore);
            if (compare != 0) {
                return compare;
            }

            compare = Integer.compare(o.mathScore, this.mathScore);
            if (compare != 0) {
                return compare;
            }

            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

        }

        Arrays.sort(students);
        StringBuilder sb = new StringBuilder();

        for (Student student : students) {
            sb.append(student.name).append('\n');
        }

        System.out.print(sb);
    }
}
