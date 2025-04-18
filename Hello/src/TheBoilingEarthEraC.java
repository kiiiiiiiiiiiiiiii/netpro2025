public class TheBoilingEarthEraC {

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

        // レベルC
        System.out.println("猛暑日連続ペア:");
        int counts[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 1; j < temperatures[i].length; j++) {
                double temps[] = temperatures[i];
                if (temps[j - 1] < 35 || temps[j] < 35)
                    continue;
                int year = START_YEAR + i, day = j + 1;
                System.out.printf("%s年7月%s日: %s°Cと     %s年7月%s日: %s°C\n", year, day - 1, temps[j - 1], year, day,
                                temps[j]);
                counts[i]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%s年: %s\n", START_YEAR + i, counts[i]);
        }
    }
}
