import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class signup extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField passwordField;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {

        new signup().setVisible(true);
    }

    public signup() {
        super("Signup page");
        setBounds(400,200,550,405);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Literata", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Literata", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Literata", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.WHITE);
        lblAnswer.setFont(new Font("Literata", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "What is your favorite color?", "What is your pet's name?", "Which is your favorite movie?" }));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.WHITE);
        lblSecurityQuestion.setFont(new Font("Literata", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        textField = new JTextField();
        textField.setBounds(265, 91, 148, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(265, 128, 148, 20);
        contentPane.add(textField_1);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(265, 165, 148, 20);
        contentPane.add(passwordField);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(265, 239, 148, 20);
        contentPane.add(textField_3);

        b1 = new JButton("Create an account");
        b1.addActionListener(this);
        b1.setFont(new Font("Literata", Font.PLAIN, 13));
        b1.setBounds(100, 289, 180, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Literata", Font.PLAIN, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);



        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("Pictures/signup_Pizza4.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 750,Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l9 = new JLabel(i29);
        l9.setBounds(0, 0, 1000, 750);
        contentPane.add(l9);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        try{
            conn con = new conn();

            if(ae.getSource() == b1){

                String sql = "insert into account(Username, Name, Password, SecurityQuestion, Answer) values (?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, passwordField.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField_3.getText());

                int i = st.executeUpdate();

                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Created your Account");
                }

                textField.setText("");
                textField_1.setText("");
                passwordField.setText("");
                textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login().setVisible(true);


            }
        }catch(Exception e){
            System.out.println(e.getMessage());




        }
    }
}
