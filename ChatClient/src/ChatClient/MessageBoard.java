package ChatClient;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MessageBoard extends JPanel {
    private JTextArea textArea = new JTextArea(25, 50);
    
    public MessageBoard() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        textArea.setEditable(false);
        
        add(new JScrollPane(textArea));
    }

    public synchronized void write(String message) {
        textArea.append(message + "\n");
    }
}
