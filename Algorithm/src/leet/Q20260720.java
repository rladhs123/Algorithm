package leet;

public class Q20260720 {

    public int countConsistentStrings(String allowed, String[] words) {
        int result = 0;

        for (String s : words) {
            boolean check = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!allowed.contains(Character.toString(c))) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result++;
            }
        }

        return result;
    }
}
