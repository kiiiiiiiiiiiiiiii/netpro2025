import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddreess {
    public static void main(String[] args) throws UnknownHostException {
        // IP Address
        InetAddress addr = InetAddress.getByName("8.8.8.8");
        // Host name
        System.out.println("Host name is: "
                + addr.getHostName());
        // Host Address
        System.out.println("Ip address is: "
                + addr.getHostAddress());
    }
}
