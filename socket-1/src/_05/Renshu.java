package _05;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Random;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Assertions;

public class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }
    // ここに続きを実装していく。

    public int sumUpToN(int x) {
        int sum = 0;
        for (int i = 0; i < x; i++)
            sum += i + 1;
        return sum;
    }

    public Integer sumFromPtoQ(int i, int j) {
        if (i > j)
            return -1;
        int sum = 1;
        for (int v = i; v < j; v++) {
            sum += v + 1;
        }
        return sum;
    }

    public Integer sumFromArrayIndex(int[] a, int i) {
        if (a.length < 0 || a.length <= i)
            return -1;
        int sum = 0;
        for (int v = i; v < a.length; v++) {
            sum += a[v];
        }
        return sum;
    }

    public Integer selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }

    public Integer selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i]);
        }
        return min;
    }

    public Integer selectMaxIndex(int[] a) {
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[index] < a[i])
                index = i;
        }
        return index;
    }

    public Integer selectMinIndex(int[] a) {
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[index] > a[i])
                index = i;
        }
        return index;
    }

    public void swapArrayElements(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true;
    }

    public void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1])
                    swapArrayElements(a, j, j + 1);
            }
        }
    }

    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int l, int r) {
        if (r - l < 1)
            return;
        int m = (l + r) / 2;
        int v = a[m];
        int li = l, ri = r;

        while (li <= ri) {
            while (a[li] < v)
                li++;
            while (a[ri] > v)
                ri--;
            if (li <= ri) {
                swapArrayElements(a, li, ri);
                li++;
                ri--;
            }
        }
        quickSort(a, l, ri);
        quickSort(a, li, r);
    }
}
