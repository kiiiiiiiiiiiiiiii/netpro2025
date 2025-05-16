import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RestaurantServer {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("ポートを入力してください(5051など) → ");
            int port = sc.nextInt();
            sc.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            RestaurantMenu menu = (RestaurantMenu) ois.readObject();

            System.out.printf("ご注文を受け取りました。ご注文は\u001B[93m%s\u001B[0mです。\n", menu.getMenuName(), menu.getMenuName());
            System.out.printf("\u001B[93m%s\u001B[0mを配膳しました。\n", menu.getMenuName());
            menu.setMessage(String.format("こちらが\u001B[93m%s\u001B[0mになります。ごゆっくりどうぞ。", menu.getMenuName()));
            oos.writeObject(menu);
            oos.flush();
            System.out.println("食事が終わりました。お会計を待ちます......");
            while (true) {
                menu = (RestaurantMenu) ois.readObject();
                if (menu.getOtsuri() < 0) {
                    menu.setMessage(String.format("金額が\u001B[31m%s円\u001B[0m不足しています。追加分をお支払いください。", - menu.getOtsuri()), true);
                    System.out.println(String.format("お支払いされましたが、\u001B[31m%s円\u001B[0m不足しています。お支払いを待ちます......", - menu.getOtsuri()));
                    oos.writeObject(menu);
                    oos.flush();
                } else {
                    menu.setMessage(String.format("お支払いありがとうございます。\u001B[34m%s円\u001B[0mのお釣りになります。\nまたのお越しをお待ちしております。", menu.getOtsuri()));
                    oos.writeObject(menu);
                    oos.flush();
                    break;
                }
            }
            System.out.println("お会計が終わりました。");

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
