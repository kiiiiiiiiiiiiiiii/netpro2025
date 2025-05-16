import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("ポートを入力してください(5051など) → ");
            int port = sc.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true) {

                System.out.print("数値を入力してください: ");
                int x = sc.nextInt();
                TaskObject task = new TaskObject();
                task.setExecNumber(x);
                oos.writeObject(task);
                if (x <= 1) {
                    System.err.println("1以下の数値が入力されました");
                    break;
                }

                task = (TaskObject) ois.readObject();
                System.out.printf("サーバーで計算された数値は%sです\n", task.getResult());
            }

            System.out.println("通信を終了します");
            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
