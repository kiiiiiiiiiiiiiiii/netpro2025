package _06;

public class CountAZTenRunnable implements Runnable {
    char ch;

    CountAZTenRunnable(char ch) {
        this.ch = ch;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread['z' - 'a' + 1];
        for (int i = 0; i < threads.length; i++) {
            CountAZTenRunnable ct = new CountAZTenRunnable((char) ('a' + i));
            threads[i] = new Thread(ct);
        }

        for (Thread t : threads) {
            t.start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Character.toString(ch) + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
