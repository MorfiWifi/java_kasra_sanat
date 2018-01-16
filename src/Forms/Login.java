package Forms;

import models.TokenModel;
import utility.Init;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lableUsername;
    private JLabel lablePass;
    private JPasswordField textePass;
    private JFormattedTextField textUsername;
    private JLabel lable;
    private JLabel lableCondition;
    private static  int count = 0;

    public Login() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onLogin() {
        // add your code here
        String usernName = textUsername.getText();
        String pass = String.valueOf(textePass.getPassword()) ;
        if (!Init.CheckInternet()){
            lableCondition.setText("Internet Is Not Connected" );
        }
        else {
            if (usernName.length() > 4 && pass.length() > 4){

                TokenModel.getToken(usernName , pass);
                if (TokenModel.isTokenBad()){
                    count++;
                    lableCondition.setText("User Didn't Verified Try again for" + count);
                }
                else {
                    dispose();
                }

            }
            else {
                lableCondition.setText("pass or Username is not Valid");
            }
        }




        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        System.exit(0);
        dispose();
    }

    public static void main() {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
