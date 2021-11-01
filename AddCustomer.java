import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddCustomer extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JPasswordField passwordField;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;

    public static void main(String[] args) {

        new AddCustomer().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddCustomer() {
        super("Add Customer");
        setBounds(400,200,600,415);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Customer ID:");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 20, 102, 22);
        contentPane.add(l1);

        t1 = new JTextField();
        t1.setEditable(false);
        t1.setForeground(new Color(0, 0, 0));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(210, 20, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);


        JLabel l3 = new JLabel("Name:");
        l3.setForeground(new Color(255, 255, 255));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(100, 70, 102, 22);
        contentPane.add(l3);

        t3 = new JTextField();
        t3.setForeground(new Color(0, 0, 0));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(210, 71, 156, 20);
        contentPane.add(t3);

        JLabel l7 = new JLabel("Password:");
        l7.setForeground(new Color(255, 255, 255));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(100, 120, 102, 22);
        contentPane.add(l7);

        passwordField= new JPasswordField();
        passwordField.setForeground(new Color(0, 0, 0));
        passwordField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        passwordField.setColumns(10);
        passwordField.setBounds(210, 123, 156, 20);
        contentPane.add(passwordField);


        JLabel l4 = new JLabel("Mobile No:");
        l4.setForeground(new Color(255, 255, 255));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(100, 170, 102, 22);
        contentPane.add(l4);

        t5 = new JTextField();
        t5.setForeground(new Color(0, 0, 0));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(210, 172, 156, 20);
        contentPane.add(t5);


        JLabel l5 = new JLabel("Email ID:");
        l5.setForeground(new Color(255, 255, 255));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(100, 222, 102, 22);
        contentPane.add(l5);

        t6 = new JTextField();
        t6.setForeground(new Color(0, 0, 0));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(210, 224, 156, 20);
        contentPane.add(t6);


        JLabel l6 = new JLabel("Pay Method:");
        l6.setForeground(new Color(255, 255, 255));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(100, 270, 102, 22);
        contentPane.add(l6);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Paytm", "PhonePe", "GPay", "Debit Card", "Credit Card", "Cash"}));
        comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox_2.setForeground(new Color(0, 0, 0));
        comboBox_2.setBounds(210, 272, 154, 20);
        contentPane.add(comboBox_2);



        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(105, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBounds(245, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        JPanel panel = new JPanel();

        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        contentPane.add(panel);
        random();

        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("Pictures/Pizza_Background3.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 750,Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l9 = new JLabel(i29);
        l9.setBounds(0, 0, 1000, 750);
        contentPane.add(l9);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    conn con = new conn();
                    String sql = "insert into add_customer(CustomerID, Name, Password, MobileNo, EmailID, PayMethod) values(?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t3.getText());
                    st.setString(3, passwordField.getText());
                    st.setString(4, t5.getText());
                    st.setString(5, t6.getText());
                    st.setString(6, (String) comboBox_2.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new HomePage().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error");
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new HomePage().setVisible(true);
            }
        } catch(Exception e){

        }
    }
}

