import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class PortManagement extends JFrame{
    private JLabel IDnumber;
    private JTextField IDTextField;
    private JLabel Weight;
    private JTextField WeightFieldText;
    private JLabel Description;
    private JTextArea DescriptionTextArea;
    private JLabel RemitentCompany;
    private JTextField ReceiverCompanyTextField;
    private JTextField RemitentCompanyTextField;
    private JLabel ReceiverCompany;
    private JButton pilebutton;
    private JButton unpileButton;
    private JTextField ColumnNumberTextField;
    private JLabel Country;
    private JLabel Operations;
    private JButton showcontainerdescriptionbutton;
    private JTextArea descriptionIsShownHereTextArea;
    private JButton numberOfContainersButton;
    private JTextArea numberIsShownHereTextArea;
    private JLabel Priority;
    private JLabel CustomInspections;
    private JComboBox CountrycomboBox1;
    private JLabel CompanyLogo;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JLabel StateHubPlan;
    private JTextArea StateTextArea1;
    private JCheckBox CustomInspectionscheckBox1;
    private JPanel MainPannel;
    private JComboBox comboBox1;
    private JTextArea IDtoshow;
    private JRadioButton hub1radiobutton;
    private JRadioButton hub2RadioButton;
    private JRadioButton hub3radiobuttom;
    private JLabel Total;
    private JLabel IDTOSHOW;
    private JButton WeightCheckbutton;
    Port port=new Port();
    int hub=1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public PortManagement(){
        setContentPane(MainPannel);
        setTitle("Port Management");
        setSize(1570,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        MainPannel.setBackground(new Color(179,1,53,255));
        IDnumber.setForeground(Color.WHITE);
        Weight.setForeground(Color.WHITE);
        Description.setForeground(Color.WHITE);
        RemitentCompany.setForeground(Color.WHITE);
        ReceiverCompany.setForeground(Color.WHITE);
        Operations.setForeground(Color.WHITE);
        Country.setForeground(Color.WHITE);
        Priority.setForeground(Color.WHITE);
        StateHubPlan.setForeground(Color.WHITE);
        CustomInspections.setForeground(Color.WHITE);
        IDTOSHOW.setForeground(Color.WHITE);
        Total.setForeground(Color.WHITE);


        pilebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container cont = new Container();
                int select = 1;
                try {
                cont.setID(Integer.parseInt(IDTextField.getText()));
                cont.setWeight(Integer.parseInt(WeightFieldText.getText()));
                cont.setDescription(DescriptionTextArea.getText());
                cont.setCountry((String) CountrycomboBox1.getSelectedItem());
                cont.setCompanySend(RemitentCompanyTextField.getText());
                cont.setCompanyReceive(ReceiverCompanyTextField.getText());
                    if (a1RadioButton.isSelected()) {
                        cont.setPriorityLevel(1);
                    }
                    if (a2RadioButton.isSelected()) {
                        cont.setPriorityLevel(2);
                    }
                    if (a3RadioButton.isSelected()) {
                        cont.setPriorityLevel(3);
                    }
                    if (CustomInspectionscheckBox1.isSelected()) {
                        cont.setInspected(true);
                    } else {
                        cont.setInspected(false);
                    }
                    if (port.hub1.stackContainer(cont) == -1) {
                        select++;
                        hub = 2;
                        if (port.hub2.stackContainer(cont) == -1) {
                            select++;
                            hub = 3;
                            if (port.hub3.stackContainer(cont) == -1) {
                                select++;
                            }
                        }
                    }
                    if (select == 1) {
                        StateTextArea1.setText("Hub 1:\n" + port.hub1.stringState());
                    }
                    if (select == 2) {
                        StateTextArea1.setText("Hub 2:\n" + port.hub2.stringState());
                    }
                    if (select == 3) {
                        StateTextArea1.setText("Hub 3\n" + port.hub3.stringState());
                    }
                    IDTextField.setText("" + (cont.ID + 1));
                    WeightFieldText.setText("");
                    DescriptionTextArea.setText("");
                    RemitentCompanyTextField.setText("");
                    ReceiverCompanyTextField.setText("");
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Error, fill correctly all the fields");
                }
            }
        });
        showcontainerdescriptionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!port.hub1.dataRegisteredContainer(Integer.parseInt(IDtoshow.getText())).equals("Not found")) {
                        descriptionIsShownHereTextArea.setText(port.hub1.dataRegisteredContainer(Integer.parseInt(IDtoshow.getText())));
                    }
                    if (!port.hub2.dataRegisteredContainer(Integer.parseInt(IDtoshow.getText())).equals("Not found")) {
                        descriptionIsShownHereTextArea.setText(port.hub2.dataRegisteredContainer(Integer.parseInt(IDtoshow.getText())));
                    }
                    if (!port.hub3.dataRegisteredContainer(Integer.parseInt(IDtoshow.getText())).equals("Not found")) {
                        descriptionIsShownHereTextArea.setText(port.hub3.dataRegisteredContainer(Integer.parseInt(IDtoshow.getText())));
                    }
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"ID should be a number.");
            }
            }
        });

        unpileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if(hub==1){
                    port.hub1.removeContainer(Integer.parseInt((ColumnNumberTextField.getText()))-1);
                    StateTextArea1.setText("Hub 1:\n"+port.hub1.stringState());
                }
                if(hub==2){
                    port.hub2.removeContainer(Integer.parseInt((ColumnNumberTextField.getText()))-1);
                    StateTextArea1.setText("Hub 2:\n"+port.hub2.stringState());
                }
                if(hub==3){
                    port.hub3.removeContainer(Integer.parseInt((ColumnNumberTextField.getText()))-1);
                    StateTextArea1.setText("Hub 3:\n"+port.hub3.stringState());
                }
            }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Column should be a number");
                }
            }
        });
        numberOfContainersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total=0;
                total=total+port.hub1.containersFromACountry((String) comboBox1.getSelectedItem());
                total=total+port.hub2.containersFromACountry((String) comboBox1.getSelectedItem());
                total=total+port.hub3.containersFromACountry((String) comboBox1.getSelectedItem());
                String show= ""+total;
                numberIsShownHereTextArea.setText(show);
            }
        });
        hub1radiobutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub1radiobutton.isSelected()){
                    hub = 1;
                    StateTextArea1.setText("Hub 1\n"+port.hub1.stringState());
                }
            }
        });
        hub2RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub2RadioButton.isSelected()){
                    hub = 2;
                    StateTextArea1.setText("Hub 2\n"+port.hub2.stringState());
                }
            }
        });
        hub3radiobuttom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub3radiobuttom.isSelected()) {
                    hub = 3;
                    StateTextArea1.setText("Hub 3\n" + port.hub3.stringState());
                }
            }
        });
        WeightCheckbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID;
                int weight;
                Container cont;
                String str="";
                ID=Integer.parseInt(IDTextField.getText());
                weight=Integer.parseInt(WeightFieldText.getText());
                if(hub1radiobutton.isSelected()) {
                    cont = port.hub1.containerWithID(ID);
                    JOptionPane.showMessageDialog(null,""+port.hub1.c1exercise(weight, cont));
                    CustomInspectionscheckBox1.setSelected(true);
                } else if (hub2RadioButton.isSelected()) {
                    cont = port.hub2.containerWithID(ID);
                    JOptionPane.showMessageDialog(null,""+port.hub2.c1exercise(weight, cont));
                    CustomInspectionscheckBox1.setSelected(true);
                } else if (hub3radiobuttom.isSelected()) {
                    cont = port.hub3.containerWithID(ID);
                    JOptionPane.showMessageDialog(null,""+port.hub3.c1exercise(weight, cont));
                    CustomInspectionscheckBox1.setSelected(true);
                }
            }
        });
    }


    public static void main(String[] args) {
        PortManagement portManagement=new PortManagement();
    }
}
