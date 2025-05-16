import java.io.Serializable;
import java.util.ArrayList;

public class TaskObject implements ITask, Serializable{
    private int x = 0;
    private int result = 0;

    public int getExecNumber() {
        return x;
    }

    @Override
    public void setExecNumber(int x) {
        this.x = x;
    }

    @Override
    public void exec() {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= x; i++) {
            boolean isPrime = true;
            for (int p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(i);
        }
        if (primes.size() <= 0) return;
        result = primes.get(primes.size() - 1);
    }

    @Override
    public int getResult() {
        return result;
    }

    public static void main(String[] args) {
        TaskObject to = new TaskObject();
        to.setExecNumber(57);
        to.exec();
        System.err.println(to.getResult());
    }

}
