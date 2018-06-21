import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Supervisor {

    private String _address;
    private DatagramSocket _serverSocket;
    private int _port;

    public Supervisor(String address, int port) {
        _address = address;
        _port = port;

    }

    public void start() {

        try {
            _serverSocket = new DatagramSocket(_port);

            //buffer
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {

                DatagramPacket receive = recv(receiveData,_port);

                InetAddress clientAddress = receive.getAddress();
                int clientPort = receive.getPort();

                DatagramPacket sendPacket = send(sendData,clientAddress,clientPort);

            }

        } catch (SocketException e) {
            System.err.println("Socket creation");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Socket receive/send");
            e.printStackTrace();
        }


    }

    private DatagramPacket recv(byte[] data, int port) throws IOException {
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        _serverSocket.receive(receivePacket);
        return receivePacket;
    }

    private DatagramPacket send(byte[] data, InetAddress address, int port) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, address, port);
        _serverSocket.send(sendPacket);
        return sendPacket;
    }


}
