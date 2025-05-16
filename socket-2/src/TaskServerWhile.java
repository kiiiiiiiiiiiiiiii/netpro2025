import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerWhile {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.err.print("ポートを入力してください(5051など) → ");
            int port = sc.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            System.out.print("接続しました。");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                System.err.println("相手の入力を待っています......");
                TaskObject task = (TaskObject) ois.readObject();
                System.out.println("クライアントから数値が入力されました");
                if (task.getExecNumber() <= 1) {
                    System.out.println("1以下の数値が入力されました");
                    break;
                }
                System.out.println("計算を開始します......");
                task.exec();
                System.out.printf("計算結果は%sでした\nクライアントに送信します\n", task.getResult());
                oos.writeObject(task);
                oos.flush();
            }

            System.err.println("通信を終了します");
            // close処理
            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
