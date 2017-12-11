package Forms;

import models.CallModel;

import javax.swing.*;
import java.awt.event.*;

public class DialogueFirst extends JDialog {
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

    public static void main(String[] args) {
        DialogueFirst dialog = new DialogueFirst();
        dialog.setSize(1500 , 900);
        CallModel callModel = new CallModel();
        callModel.getcallFromServer(dialog.list1);
        dialog.pack();
        dialog.setVisible(true);

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
