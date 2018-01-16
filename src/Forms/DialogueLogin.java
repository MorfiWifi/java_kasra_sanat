package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by WifiMorfi on 12/11/2017.
 */
public class DialogueLogin {


    private static DialogueLogin Dialogue;
    private JPanel panel1;
    private JPasswordField textePass;
    private JFormattedTextField textUsername;
    private JButton btnLogin;
    private JButton btnCancle;
    private JLabel lableUsername;
    private JLabel lablePass;
    private JLabel lable;
    private JLabel lableCondition;

    public DialogueLogin() {
        btnCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main() {
        if (Dialogue == null){
            Dialogue = new DialogueLogin();
        }


    }
}
