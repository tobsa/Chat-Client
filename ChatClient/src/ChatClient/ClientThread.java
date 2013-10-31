package ChatClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable {
    private MessageBoard messageBoard;
    private DataInputStream input;
    private DataOutputStream output;
    private IMFListener listener;
    
    public ClientThread(MessageBoard messageBoard, Socket socket, IMFListener listener) {
        this.messageBoard = messageBoard;
        this.listener     = listener;
        
        try {
            input  = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {}
    }
    
    public void sendMessage(String message) {
        try {
            output.writeUTF(message);
        } catch (IOException ex) {}
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                String message = input.readUTF();
                listener.dispatchMessage(message);
            } catch (IOException ex) {}
        }
    }
}
