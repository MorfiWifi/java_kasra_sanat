package Forms;

import models.CallModel;
import models.LogInViewModel;
import models.TokenModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogueCallsModel extends JDialog {
    private static DialogueCallsModel Dialogue;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JProgressBar progressBar1;
    public JList list1;


    public DialogueCallsModel() {
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
            Dialogue = new DialogueCallsModel();
        }

        Dialogue.setSize(1500 , 900);
       // LogInViewModel logInViewModel = new LogInViewModel();
       // logInViewModel.setUserName("admin");
       // logInViewModel.setPassword("bbBB11!!");
       // LogInViewModel.LoginAsync(Dialogue.list1 , logInViewModel);

        // >>> CHOOSE WHAT TO DO ?!??
        //CallModel.getToken();
        TokenModel.getToken();
        while   (TokenModel.TokenSTR.length() < 2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Dialogue.list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList jList = (JList)e.getSource();
                if (e.getClickCount() == 2){
                    int index = jList.locationToIndex(e.getPoint());
                    // TODO: 1/15/2018  Edit method in This Model
                    DialogueCall_Edit.main(CallModel.list.get(index) , Dialogue);


                }
                super.mouseClicked(e);
            }
        });

        CallModel.getcallFromServer(Dialogue.list1 , CallModel.list);



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

    // Morfi INIT

    public void Init (){
        //DialogueCallsModel dialog = new DialogueCallsModel();
        this.setSize(1500 , 900);
        this.pack();

        this.setVisible(true);
        //System.exit(0);

    }
}
