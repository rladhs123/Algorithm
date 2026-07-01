package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260701 {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            result.add("Push");

            if (target[index] == i) {
                index++;
            } else {
                result.add("Pop");
            }

            if (target.length == index) {
                break;
            }
        }

        return result;
    }
}
