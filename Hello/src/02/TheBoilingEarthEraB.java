public class TheBoilingEarthEraB {

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

        // レベルB
        System.out.println("真夏日連続ペア:");
        for (int i = 1; i < temperatures[2025 - START_YEAR].length; i++) {
            double temps[] = temperatures[2025 - START_YEAR];
            int day = i + 1;
            if (temps[i - 1] < 30 || temps[i] < 30)
                continue;
            System.out
                    .printf("2025年7月%s日: %s°Cと     2025年7月%s日: %s°C\n", day - 1, temps[i - 1], day,
                            temps[i]);
        }
    }
}
