package ChatClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread implements Runnable, IMFListener {
    private MessageBoard messageBoard;
    private ServerSocket serverSocket;
    private List<ClientThread> clients = new ArrayList();
    
    public Server(MessageBoard messageBoard, String name, int port) {
        this.messageBoard = messageBoard;
        
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void dispatchMessage(String message) {        
        messageBoard.write(message);
        
        for(ClientThread client : clients)
            client.sendMessage(message);
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                ClientThread client = new ClientThread(serverSocket.accept(), this);
                new Thread(client).start();
                
                clients.add(client);
            } catch (IOException ex) {}
        }
    }
}
