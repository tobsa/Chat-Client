package ChatClient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ChatFrame extends JFrame implements Constants {
    private MessageBoard messageBoard = new MessageBoard();
    private MessageField messageField = new MessageField();
    
    public ChatFrame() {
        JButton button1 = new JButton("Connect");
        JButton button2 = new JButton("Exit");
        button1.addActionListener(new ButtonConnectListener());
        button2.addActionListener(new ButtonExitListener());
        
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(button1);
        panel1.add(button2);
        panel1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 0, 10), new EtchedBorder()));
        
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(messageBoard);
        panel2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 10, 0, 10), new EtchedBorder()));
        
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3.add(messageField);
        panel3.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 10, 10, 10), new EtchedBorder()));
        
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        
        pack();
    }
    
    private class ButtonConnectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConnectDialog dialog = new ConnectDialog(ChatFrame.this);
            
            if(dialog.getSelection() == CONNECT_BUTTON_CANCEL)
                return;
            
            if(dialog.getChatType() == SERVER) {
                Server server = new Server(messageBoard, "Server", 8080);
                messageField.registerListener(server);
                server.start();
            }
            else {
                Client client = new Client(messageBoard, "Client", "localhost", 8080);
                messageField.registerListener(client);
                client.start();
            }
        }
    }
    
    private class ButtonExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
