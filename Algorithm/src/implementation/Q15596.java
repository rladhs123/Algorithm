package implementation;

public class Q15596 {

    long sum(int[] array) {
        long sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }
}
