package Forms;

import models.CallModel;
import models.LogInViewModel;

import javax.swing.*;
import java.awt.event.*;

public class DialogueFirst extends JDialog {
    private static DialogueFirst Dialogue;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JProgressBar progressBar1;
    private JList list1;

    public DialogueFirst() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        //getRootPane().setSize(1500 , 900);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main() {
        if (Dialogue == null){
            Dialogue = new DialogueFirst();
        }

        Dialogue.setSize(1500 , 900);
        LogInViewModel logInViewModel = new LogInViewModel();
        logInViewModel.setUserName("admin");
        logInViewModel.setPassword("bbBB11!!");
        LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);
        CallModel.getcallFromServer(Dialogue.list1);
        Dialogue.pack();
        Dialogue.setVisible(true);

        //dialog.list1.add();
        System.exit(0);
    }

    // Morfi INIT

    public void Init (){
        //DialogueFirst dialog = new DialogueFirst();
        this.setSize(1500 , 900);
        this.pack();
        this.setVisible(true);
        System.exit(0);

    }
}
