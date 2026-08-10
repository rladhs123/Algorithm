package leet;

public class Q20260810 {

    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];
        result[0] = celsius + 273.15;
        result[1] = (celsius * 1.80) + 32.00;

        return result;
    }
}
