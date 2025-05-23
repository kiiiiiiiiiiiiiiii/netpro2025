package _06;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            for (int i = 0; i < 100; i++) {
                socket = new DatagramSocket();
                InetAddress serverAddress = InetAddress.getByName("loocalhost");
                // InetAddress serverAddress = InetAddress.getByName("133.20.69.143");
                String message = "I love Iwai... Please S :D";
                byte[] sendData = message.getBytes();

                // 送信パケットを作成
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}