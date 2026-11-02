package leet;

public class Q20261102 {

    public String convertDateToBinary(String date) {
        String[] arr = date.split("-");
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            String b = Integer.toBinaryString(Integer.parseInt(s));
            sb.append(b);
            sb.append('-');
        }

        String result = sb.toString();

        return result.substring(0, result.length() - 1);
    }
}
