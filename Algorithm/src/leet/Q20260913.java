package leet;

public class Q20260913 {

    public String trafficSignal(int timer) {
        String s = "";

        if (timer == 0) {
            s = "Green";
        } else if (timer == 30) {
            s = "Orange";
        } else if (timer > 30 && timer <= 90) {
            s = "Red";
        } else {
            s = "Invalid";
        }

        return s;
    }
}
