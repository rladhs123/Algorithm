package leet;

public class Q20260924 {

    public boolean canWinNim(int n) {
        boolean result = true;

        if (n % 4 == 0) {
            result = false;
        }

        return result;
    }
}
