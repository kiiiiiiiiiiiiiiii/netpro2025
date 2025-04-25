public class TryCatchExample {
    public static void main(String[] args) {
        try {
            // 例外が発生する可能性のあるコードを記述
            int[] numbers = { 1, 2, 3 };
            System.out.println(numbers[4]); // 配列の範囲外にアクセス
        } catch (ArrayIndexOutOfBoundsException e) {
            // 例外が発生した場合の処理を記述
            System.out.println("配列の範囲外にアクセスしました。");
        }
    }
}