package ChatClient;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MessageField extends JPanel {
    private JTextField textField = new JTextField(45);
    private JButton button = new JButton("Send");
    private List<IMFListener> listeners = new ArrayList();
    
    public MessageField() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        button.addActionListener(new ButtonListener());
        
        add(textField);
        add(button);
    }
    
    public void registerListener(IMFListener listener) {
        listeners.add(listener);
    }
        
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = textField.getText();
            
            if(message.isEmpty())
                return;
            
            textField.setText("");
            
            for(IMFListener listener : listeners)
                listener.dispatchMessage(message);
        }
    }
}
