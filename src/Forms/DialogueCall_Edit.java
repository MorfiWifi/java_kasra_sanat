package Forms;

import models.CallModel;
import models.LogInViewModel;

import javax.swing.*;
import java.awt.event.*;

public class DialogueCall_Edit extends JDialog {
    private static DialogueCall_Edit Dialogue;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textMessage;
    private JLabel lableID;
    private JLabel lableDate;
    private JButton buttRemove;
    public DialogueCallsModel paprent;
    private CallModel callModel;

    public DialogueCall_Edit() {
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
        buttRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRemove();
            }
        });
    }

    private void onOK() {
        // add your code here
        if (textMessage.getText().trim().length() > 1){
            callModel.Message = textMessage.getText();
            CallModel.Edit_CallModel(callModel , paprent.list1 , CallModel.list);
        }




        dispose();
    }

    private void onRemove() {
        // add your code here
        if (textMessage.getText().trim().length() > 1){
            callModel.Message = textMessage.getText();
            CallModel.Remove_CallMOdel(callModel , paprent.list1 , CallModel.list);
        }

        dispose();
    }

    public void fill_Edit (CallModel callModel){
        lableID.setText(String.valueOf(callModel.Id));
        lableDate.setText(String.valueOf(callModel.Date));
        textMessage.setText(callModel.Message);
    }

    public static void main() {
        if (Dialogue == null){
            Dialogue = new DialogueCall_Edit();
        }

        Dialogue.setSize(1500 , 900);



        //LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);
        //CallModel.getcallFromServer(Dialogue.list1);
        Dialogue.pack();
        Dialogue.setVisible(true);

        //dialog.list1.add();
        //System.exit(0);
    }

    public static void main( CallModel callModel , DialogueCallsModel paprent) {
        if (Dialogue == null){
            Dialogue = new DialogueCall_Edit();
        }

        Dialogue.setSize(1500 , 900);

        Dialogue.paprent = paprent;
        Dialogue.callModel = callModel;


        //LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);
        //CallModel.getcallFromServer(Dialogue.list1);
        Dialogue.fill_Edit(callModel);
        Dialogue.pack();
        Dialogue.setVisible(true);

        //dialog.list1.add();
        //System.exit(0);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
