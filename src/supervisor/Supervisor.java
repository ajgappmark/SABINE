package supervisor;

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
                DatagramPacket rcv = new DatagramPacket(receiveData, receiveData.length);
                _serverSocket.receive(rcv);

                InetAddress clientAddress = rcv.getAddress();
                int clientPort = rcv.getPort();

                DatagramPacket response = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                _serverSocket.send(response);
            }

        } catch (SocketException e) {
            System.err.println("Socket creation");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Socket receive");
            e.printStackTrace();
        }


    }

    public void send(byte[] data, InetAddress address, int port) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, address, port);
        _serverSocket.send(sendPacket);
    }


}
