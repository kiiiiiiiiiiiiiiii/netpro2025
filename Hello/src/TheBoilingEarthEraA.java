public class TheBoilingEarthEraA {

    public static void main(String[] args) {
        double[][] temperatures = new double[10][31];
        final int START_YEAR = 2016;
        final double START_TEMP = 29.0;
        for (int i = 0; i < temperatures.length; i++) {
            double ave = START_TEMP + 0.3 * i;
            for (int j = 0; j < temperatures[i].length; j++) {
                double temp = ave + Math.random() * 10 - 5;
                temp = (double) Math.round(temp * 10) / 10;
                temperatures[i][j] = temp;
            }
        }

        // レベルA
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < temperatures[i].length; j++) {
                int year = START_YEAR + i, day = j + 1;
                double temp = temperatures[i][j];
                System.out.printf("%s年7月%s日: %s°C\n", year, day, temp);
            }
        }
    }
}
