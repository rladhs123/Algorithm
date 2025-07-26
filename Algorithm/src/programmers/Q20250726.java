package programmers;

public class Q20250726 {

    static int solution(int n) {
        int answer = 0;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < array.length; i++) {
            array[i] = (array[i - 2] + array[i - 1]) % 1234567;
        }

        answer = array[n];

        return answer;
    }

    public static void main(String[] args) {
        int result = solution(5);
        System.out.println(result);
    }
}
