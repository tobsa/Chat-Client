package ChatClient;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MessageField extends JPanel {
    private JTextField textField = new JTextField(45);
    private JButton button = new JButton("Send");
    
    public MessageField() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        button.addActionListener(new ButtonListener());
        
        add(textField);
        add(button);
    }
    
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
