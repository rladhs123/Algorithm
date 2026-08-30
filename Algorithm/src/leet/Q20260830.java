package leet;

public class Q20260830 {

    public int findClosest(int x, int y, int z) {
        int xz = Math.abs(z - x);
        int yz = Math.abs(z - y);

        if (xz < yz) {
            return 1;
        } else if (xz > yz) {
            return 2;
        } else {
            return 0;
        }
    }
}
