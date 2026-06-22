package programmers;

public class Q20260622 {

    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] arr = my_string.split("");
        String tmp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = tmp;

        for (String s : arr) {
            answer += s;
        }

        return answer;
    }
}
