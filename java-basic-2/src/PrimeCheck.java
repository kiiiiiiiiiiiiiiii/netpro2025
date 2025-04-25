import java.util.ArrayList;
import java.util.Arrays;

public class PrimeCheck {
    public static void main(String[] args) {
        ArrayList primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= 100000; i++) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                int p = (int) primes.get(j);
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(i);
        }

        int[][] pair = new int[100][2];
        for (int i = 2; i < primes.size(); i++) {
            int a = (int)primes.get(i - 1) % 10;
            int b = (int)primes.get(i) % 10;
            pair[a * 10 + b][1] = a * 10 + b;
            pair[a * 10 + b][0]++;
        }
        Arrays.sort(pair, (a, b) -> {
            return b[0] - a[0];
        });
        for (int[] num : pair) {
            int a = num[1] / 10, b = num[1] % 10;
            if (num[0] <= 1) continue;
            System.out.printf("%s-%s %s\n", a, b, num[0]);
        }
    }
}
