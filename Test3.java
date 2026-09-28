public class Test3 {
    public static void main(String[] args) {
        int[] integer = {1, 2, 3};

        double[] decimals = new double[integer.length];

        for (int i = 0; i < integer.length; i++) {
            decimals[i] = integer[i];
        }

        System.out.println(decimals[0]);
    }
}
