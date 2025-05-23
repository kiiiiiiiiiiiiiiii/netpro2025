package _06;

public class PrimeExThreadsMain extends Thread {
    private int start;

    PrimeExThreadsMain(int start) {
        this.start = start;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[9];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new PrimeExThreadsMain((i + 1) * 100);
        }
        for (Thread t : threads) {
            t.start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            int value = start + i;
            System.out.printf("%s: %s\n", value, isPrime(value));
        }
    }

    private boolean isPrime(int value) {
        if (value <= 1)
            return false;
        if (value % 2 == 0 || value % 3 == 0)
            return false;
        for (int i = 5; i * i <= value; i += 6) {
            if (value % i == 0 || value % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
