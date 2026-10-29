package leet;

public class Q20261029 {

    static class ParkingSystem {

        int big, medium, small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            boolean result = false;

            if (carType == 1) {
                if (big >= 1) {
                    result = true;
                    big--;
                }
            } else if (carType == 2) {
                if (medium >= 1) {
                    result = true;
                    medium--;
                }
            } else {
                if (small >= 1) {
                    result = true;
                    small--;
                }
            }

            return result;
        }
    }
}
