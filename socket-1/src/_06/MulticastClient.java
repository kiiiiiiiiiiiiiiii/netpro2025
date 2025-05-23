package _06;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            // 自分のPC内でやる場合
            InetAddress group = InetAddress.getByName("224.0.0.1");
            // 隣の人とやる場合
            // InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            // データ送信用のソケットを作成
            MulticastSocket socket = new MulticastSocket();

            // 送信するコマンドを設定
            String command = "やあ";

            // コマンドをバイト配列に変換して DatagramPacket を作成し、マルチキャストグループに送信
            byte[] buffer = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Command sent: " + command);

            // ソケットを閉じる
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}