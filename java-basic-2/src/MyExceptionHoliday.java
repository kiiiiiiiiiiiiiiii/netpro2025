import java.util.Scanner;

public class MyExceptionHoliday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("5月の何日ですか？（終了したい場合はexitと入力）：");
            System.out.println();
            String input = sc.nextLine();
            if (input.equals("exit"))
                break;
            int day = 0;
            try {
                day = Integer.parseInt(input);
            } catch (Exception e) {
                System.err.println("不正な値です。");
                continue;
            }
            try {
                test(day);
                System.out.println(day + "日はお休みです。");
            } catch (NoHolidayException e) {
                e.printStackTrace();
                System.err.println("この日は平日だよ！はたらきたくないねー。エラーメッセージです。");
            }
        }
    }

    static private final int[] HOLIDAYS = { 3, 4, 5, 6, 10, 11, 17, 18, 24, 25, 31 };
    static void test(int day) throws NoHolidayException {
        boolean isError = true;
        for (int holiday : HOLIDAYS) {
            if (holiday == day) {
                isError = false;
                break;
            }
        }
        if (isError) {
            throw new NoHolidayException();
        }
    }
}
