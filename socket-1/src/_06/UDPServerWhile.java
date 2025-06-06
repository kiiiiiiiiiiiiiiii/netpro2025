package _06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPServerWhile {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // 受信パケットの準備
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                System.out.println("サーバーはクライアントからのメッセージを待っています...");

                // クライアントからのデータを受信
                socket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("受信: " + clientMessage);

                // クライアントからqが送られてきたら終了する
                if (clientMessage.equals(("q"))) {
                    System.out.println("終了します");
                    break;
                }

                // サーバーからの返信をユーザに入力させる
                System.out.print("返信を入力してください: ");
                String serverResponse = scanner.nextLine();
                sendData = serverResponse.getBytes();

                // クライアントのアドレスとポートを取得
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // 返信をクライアントに送信
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}