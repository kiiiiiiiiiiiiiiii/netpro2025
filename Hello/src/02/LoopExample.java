public class LoopExample {
    public static void main(String[] args) {
        // forループの例
        System.out.println("forループのデモ:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i); // 1から5までの数字を出力
        }

        // whileループの例
        System.out.println("whileループのデモ:");
        int j = 1;
        while (j <= 5) {
            System.out.println("j = " + j); // jが1から5まで増加する間、このブロックが繰り返し実行される
            j++;
        }

        // do-whileループの例
        System.out.println("do-whileループのデモ:");
        int k = 1;
        do {
            System.out.println("k = " + k); // 最初の実行を保証し、その後kが5以下である間繰り返し実行
            k++;
        } while (k <= 5);

    }
}
