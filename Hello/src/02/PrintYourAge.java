import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PrintYourAge {
    public static void main(String[] args) {
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        // BufferedReader というのは、データ読み込みのクラス(型)
        // クラスの変数を作るには、new を使う。

        // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
        // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX } と書く
        while (true) {

            try {
                System.out.println("何歳ですか?");
                String line = scanner.nextLine();
                if (line.equals("q") || line.equals("e")) {
                    System.out.println("終了します");
                    break;
                }
                int age = Integer.parseInt(line);
                if (age < 0 || age >= 120) {
                    System.out.println("値が小さすぎるか大きすぎます。\nもう一度入力してください。");
                    continue;
                }
                LocalDateTime now = LocalDateTime.now();
                System.out.println("あなたは2030年には、" + (age + 2030 - now.getYear()) + "歳ですね。");
                LocalDateTime born = now.minusYears(age);
                JapaneseDate jnow = JapaneseDate.from(born);
                System.out.print("あなたの生まれた年は");
                if (jnow.format(DateTimeFormatter.ofPattern("yyy")).equals("001")) {
                    System.out.print(jnow.format(DateTimeFormatter.ofPattern("G元年")));
                } else {
                    System.out.print(jnow.format(DateTimeFormatter.ofPattern("Gyyy年")));
                }
                System.out.println("です。");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("値が不正です。\nもう一度入力してください。");
            }
        }
    }
}
