package _06;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MulticastServer {
    // マルチキャストグループのIPアドレスとポート番号を指定
    // 自分のPC内でやる場合(隣の人とやる場合は以下を"239.0.0.1"に変更)
    private static final String MULTICAST_ADDRESS = "224.0.0.1";
    // private static final String MULTICAST_ADDRESS = "239.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        MulticastSocket multicastSocket = null;
        InetAddress group = null;
        NetworkInterface networkInterface = null;

        try {
            group = InetAddress.getByName(MULTICAST_ADDRESS);

            // マルチキャストソケットを作成し、指定したグループとポートに参加
            multicastSocket = new MulticastSocket(PORT);

            // 自分のPCのネットワークインターフェースを取得
            networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

            multicastSocket.joinGroup(new InetSocketAddress(group, PORT), networkInterface);

            System.out.println("Server started. Waiting for commands...");

            // 受信用のバッファを作成 256byteに設定
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // コマンドを受信して永遠に待機
            while (true) {
                multicastSocket.receive(packet);
                String receivedCommand = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received command: " + receivedCommand);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (multicastSocket != null && !multicastSocket.isClosed()) {
                try {
                    // グループから離脱
                    multicastSocket.leaveGroup(new InetSocketAddress(group, PORT), networkInterface);
                } catch (IOException e) {
                    System.err.println("グループ離脱時にエラーが発生: " + e.getMessage());
                }
                multicastSocket.close();
            }
        }
    }
}
