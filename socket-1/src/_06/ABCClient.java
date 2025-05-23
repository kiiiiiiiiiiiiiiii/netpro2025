package _06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ABCClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // クライアントからのメッセージをユーザに入力させる
                System.out.print("英小文字を入力してください(例: abc): ");
                String clientMessage = scanner.nextLine();
                sendData = clientMessage.getBytes();

                // メッセージをサーバに送信
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                socket.send(sendPacket);

                // 終了処理
                if (clientMessage.equals("q")) {
                    System.out.println("終了します");
                    break;
                }

                // サーバからの返信を受信
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("サーバからの返信: " + serverResponse);
            } // while end

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } // try catch finally end
    } // main end
}
