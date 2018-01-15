package Forms;

import models.LogInViewModel;
import models.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogueProducers extends JDialog {
    private static DialogueProducers Dialogue;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;

    public DialogueProducers() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
    public static void main() {
        if (Dialogue == null) {
            Dialogue = new DialogueProducers();
        }

        Dialogue.setSize(1500, 900);


        Dialogue.list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList jList = (JList)e.getSource();
                if (e.getClickCount() == 2){
                    int index = jList.locationToIndex(e.getPoint());
                    // TODO: 1/15/2018  Edit method in This Model



                }
                super.mouseClicked(e);
            }
        });

        //LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);
        //CallModel.getcallFromServer(Dialogue.list1);
        Dialogue.pack();
        Dialogue.setVisible(true);
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
