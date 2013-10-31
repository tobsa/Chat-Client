package ChatClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread implements Runnable, IMFListener {
    private MessageBoard messageBoard;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    
    public Client(MessageBoard messageBoard, String name, String ip, int port) {
        this.messageBoard = messageBoard;
        
        try {
            socket = new Socket(ip, port);
            
            input  = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } 
        catch (UnknownHostException ex) {} 
        catch (IOException ex) {}
    }
        
    @Override
    public void dispatchMessage(String message) {
        try {
            output.writeUTF(message);
        } catch (IOException ex) {}
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                String message = input.readUTF();
                messageBoard.write(message);
            } catch (IOException ex) {}
        }
    } 
}
