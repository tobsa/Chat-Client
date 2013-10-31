package ChatClient;

import javax.swing.JFrame;

public class ChatClient {
    public static void main(String[] args) {
        ChatFrame frame = new ChatFrame();
        frame.setTitle("ChatClient");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
