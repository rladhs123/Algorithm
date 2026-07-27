package leet;

public class Q20260727 {

    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");

        return array[array.length - 1].length();
    }
}
