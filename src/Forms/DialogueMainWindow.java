package Forms;

import javax.swing.*;
import java.awt.event.*;

public class DialogueMainWindow extends JDialog {
    private static DialogueMainWindow Dialogue;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton incomeCalls;
    private JButton customers;
    private JButton orders;
    private JButton producers;
    private JButton contracts;
    private JButton products;
    private JButton users;
    private JButton accountant;

    public DialogueMainWindow() {
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

        incomeCalls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogueCallsModel.main();
            }
        });

        customers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogueCostumers.main();
            }
        });

        contracts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogueContracts.main();
            }
        });
        products.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogueProducts.main();
            }
        });
        orders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DialogueOrders.main();
            }
        });
        producers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DialogueProducers.main();
            }
        });
        users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogueUsers.main();
            }
        });
        accountant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DialogueAccountant.main();
            }
        });
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
            Dialogue = new DialogueMainWindow();
        }

        Dialogue.setSize(1500 , 900);
        //LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);
        //CallModel.getcallFromServer(Dialogue.list1);
        Dialogue.pack();
        Dialogue.setVisible(true);
        //dialog.list1.add();
        System.exit(0);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
