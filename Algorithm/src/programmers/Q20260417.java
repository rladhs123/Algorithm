package programmers;

public class Q20260417 {

    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for (String[] member : db) {
            if (id_pw[0].equals(member[0])) {
                if (id_pw[1].equals(member[1])) {
                    answer = "login";
                } else {
                    answer = "wrong pw";
                }
            }
        }

        return answer;
    }
}
