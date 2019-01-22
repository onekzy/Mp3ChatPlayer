package sample.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server implements ConnectionListener {

    private final ArrayList<Connection> connections = new ArrayList<>();

    public Server() {
        System.out.println("Server running...");
        try {
            ServerSocket serverSocket = new ServerSocket(8177);
            while (true) {
                try{
                    new Connection(this, serverSocket.accept());
                } catch (IOException e) {
                    System.out.println("Connection exception: "+e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public synchronized void onConnectionReady(Connection connection) {
        connections.add(connection);
        sendToAllConnectons("Client connected " + connection);
    }

    @Override
    public synchronized void onRecieveString(Connection connection, String value) {
        sendToAllConnectons(value);
    }

    @Override
    public synchronized void onDisconnect(Connection connection) {
        connections.remove(connection);
        sendToAllConnectons("Client disconnected " + connection);

    }

    @Override
    public synchronized void onException(Connection connection, Exception e) {
        System.out.println("Connection exception " + e);
    }

    private void sendToAllConnectons(String value) {
        System.out.println(value);
        for(int i = 0; i<connections.size(); i++) {
            connections.get(i).sendString(value);
        }
    }
}
