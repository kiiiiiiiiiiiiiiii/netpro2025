import java.util.Arrays;
import java.util.Random;

public class AverageC {
    public static void main(String[] args) {
        Random random = new Random();
        Subject[] results = new Subject[100];
        float ave = 0;
        for (int i = 0; i < results.length; i++) {
            results[i] = new Subject(random.nextInt(101));
            results[i].studentid = i + 100;
            ave += results[i].score;
        }
        ave /= results.length;
        System.out.printf("受験者全体での平均点は%s点です。\n\n", ave);
        System.out.println("合格者の一覧は以下。");
        System.out.println("受験番号,点数");
        Arrays.sort(results, (a, b) -> {
            return a.score - b.score;
        });
        for (var r : results) {
            if (r.score >= 80) System.out.printf("%s,%s\n", r.studentid, r.score);
        }
    }
}
