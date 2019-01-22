package sample.Chat;

import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;

public class Connection {
    private final Socket socket;
    private final Thread rxThread;
    private final ConnectionListener eventListener;
    private final BufferedReader in;
    private final BufferedWriter out;

    public Connection(ConnectionListener eventListener, String ipAddr, int port) throws IOException {
        this(eventListener, new Socket(ipAddr, port));
    }

    public Connection(ConnectionListener eventListener ,Socket socket) throws IOException {
        this.eventListener = eventListener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    eventListener.onConnectionReady(Connection.this);
                    while (!rxThread.isInterrupted()) {
                        eventListener.onRecieveString(Connection.this, in.readLine());
                    }
                } catch (IOException e) {
                    eventListener.onException(Connection.this, e);
                } finally {
                    eventListener.onDisconnect(Connection.this);
                }
            }
        });
        rxThread.start();
    }

    public synchronized void sendString(String value) {
        try {
            out.write(value +"\r\n");
            out.flush();
        } catch (IOException e) {
            eventListener.onException(Connection.this, e);
            disconnect();
        }
    }

    public synchronized void disconnect() {
        rxThread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onException(Connection.this, e);
        }
    }

    @Override
    public String toString() {
        return "Connection: " + socket.getInetAddress() + " " + socket.getPort();
    }
}