package ChatClient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ConnectDialog extends JDialog implements Constants {
    private JComboBox<String> jcbChatType = new JComboBox();
    private JTextField jtfName = new JTextField(10);
    private JTextField jtfIP   = new JTextField(10);
    private JTextField jtfPort = new JTextField(10);
    private int selection;
    
    public ConnectDialog(JFrame parent) {
        jcbChatType.addItem("Server");
        jcbChatType.addItem("Client");
        
        JButton button1 = new JButton("OK");
        JButton button2 = new JButton("Cancel");
        button1.addActionListener(new ButtonOKListener());
        button2.addActionListener(new ButtonCancelListener());
        
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(jcbChatType);
        panel1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 0, 10), new EtchedBorder()));
        
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(button1);
        panel2.add(button2);
        panel2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 10, 10, 10), new EtchedBorder()));
        
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        
        pack();
        
        setTitle("Connect");
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setVisible(true);
    }
    
    public int getSelection() {
        return selection;
    }
    
    public String getPlayerName() {
        return jtfName.getText();
    }
    
    public String getIP() {
        return jtfIP.getText();
    }
    
    public int getPort() {
        return Integer.parseInt(jtfPort.getText());
    }
    
    public int getChatType() {
        return jcbChatType.getSelectedIndex();
    }
    
    private class ButtonOKListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selection = CONNECT_BUTTON_OK;
            dispose();
        }
    }
    
    private class ButtonCancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selection = CONNECT_BUTTON_CANCEL;
            dispose();
        }
    }
}
