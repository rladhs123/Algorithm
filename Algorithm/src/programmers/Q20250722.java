package programmers;

public class Q20250722 {

    static String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] array = s.toLowerCase().split(" ", -1);


        for (int i = 0; i < array.length; i++) {
            if (array[i].length() != 0) {
                sb.append(array[i].substring(0, 1).toUpperCase()).append(array[i].substring(1)).append(" ");
            } else {
                sb.append(" ");
            }
        }

        answer = sb.toString();

        return answer.substring(0, answer.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(solution("for the last week"));
    }
}
