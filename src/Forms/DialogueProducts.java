package Forms;

import models.LogInViewModel;
import models.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogueProducts extends JDialog {
    private static DialogueProducts Dialogue;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;

    public DialogueProducts() {
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
        Dialogue.dispose();
        //dispose();
    }
    public static void main() {
        if (Dialogue == null){
            Dialogue = new DialogueProducts();
        }

        Dialogue.setSize(1500 , 900);

        //LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);
        //CallModel.getcallFromServer(Dialogue.list1);
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

        ProductModel.getProductFromServer(Dialogue.list1 , ProductModel.lis);

        Dialogue.pack();
        Dialogue.setSize(400 , 400);
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - Dialogue.getWidth()) / 2;
        final int y = (screenSize.height - Dialogue.getHeight()) / 2;
        Dialogue.setLocation(x, y);
        Dialogue.setVisible(true);



        //dialog.list1.add();
       // System.exit(0);
    }
    private void onCancel() {
        // add your code here if necessary
        Dialogue.dispose();
    }
}
