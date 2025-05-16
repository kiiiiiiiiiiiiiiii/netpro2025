import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class RestaurantClient {
    public static int getInt(Scanner sc) {
        while (true) {
            try {
                int ret = sc.nextInt();
                if (ret < 0) throw new Exception();
                return Math.abs(ret);
            } catch (Exception e) {
                System.out.print("不正な値を入力しました。やめてね。もう一度入力しなおしてください:");
                sc.nextLine();
            }
        }
    }

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5051など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.print("メニュー番号を入力してください:");
            int menuId = getInt(scanner);
            RestaurantMenu menu = new RestaurantMenu(menuId);
            oos.writeObject(menu);
            oos.flush();
            menu = (RestaurantMenu) ois.readObject();
            System.out.println(menu.getMessage());
            System.err.printf("食事が終わりました。お会計は\u001B[93m%s円\u001B[0mになります\n", menu.getCost());
            while (true) {
                System.out.print("お金をお支払いください:");
                int cost = getInt(scanner);
                menu.addMoney(cost);
                oos.writeObject(menu);
                oos.flush();
                menu = (RestaurantMenu) ois.readObject();
                System.out.println(menu.getMessage());
                if (!menu.getIsError()) break;
            }

            // System.out.println("メッセージを入力してください(例:メリークリスマス) ↓");
            // String message = scanner.next();
            // System.out.println("プレゼントの内容を入力してください(例:お菓子) ↓");
            // String content = scanner.next();
            // scanner.close();

            // XmasPresent present = new XmasPresent();
            // present.setMessage(message);
            // present.setContent(content);

            // oos.writeObject(present);
            // oos.flush();

            // XmasPresent okaeshiPresent = (XmasPresent) ois.readObject();

            // String replayMsg = okaeshiPresent.getMessage();
            // System.out.println("サーバからのメッセージは" + replayMsg);
            // String replayContent = okaeshiPresent.getContent();
            // System.out.println(replayContent + "をもらいました！");

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
