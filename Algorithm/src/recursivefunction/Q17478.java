package recursivefunction;

import java.util.Scanner;

/**
 * 재귀함수가 뭔가요?
 *
 * 중앙대학교와 자신의 길이 맞지 않다고 생각한 JH 교수님은 결국 중앙대학교를 떠나기로 결정하였다.
 * 떠나기 전까지도 제자들을 생각하셨던 JH 교수님은 재귀함수가 무엇인지 물어보는 학생들을 위한 작은 선물로 자동 응답 챗봇을 준비하기로 했다.
 * JH 교수님이 만들 챗봇의 응답을 출력하는 프로그램을 만들어보자.
 */
public class Q17478 {

    static int N;
    static String s1 = "\"재귀함수가 뭔가요?\"";
    static String s2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String s3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String s4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String s5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String s6 = "라고 답변하였지.";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");


        recur(0);
        System.out.println(sb);

    }

    static void recur(int n) {
        String underBar = "";
        for (int i = 0; i < 4 * n; i++) {
            underBar += "_";
        }
        if (n == N) {
            sb.append(underBar + s1 + '\n' + underBar + s5 + '\n' + underBar + s6 + '\n');
            return;
        } else {
            sb.append(underBar + s1 + '\n' + underBar + s2 + underBar + s3 + underBar + s4 +'\n');
        }
        recur(n + 1);
        sb.append(underBar + s6 + '\n');
    }
}
