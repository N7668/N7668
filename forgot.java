import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class forgot extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JButton b1, b2, b3;
    private JComboBox comboBox;

    public static void main(String[] args) {
        new forgot().setVisible(true);
    }

    public forgot() {
        super("Forgot Password");
        setBounds(400, 200, 700, 440);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Username:");
        l1.setFont(new Font("Literata", Font.BOLD, 13));
        l1.setBounds(109, 82, 75, 21);//y=122
        l1.setForeground(new Color(255, 255, 255));
        contentPane.add(l1);

        JLabel l2 = new JLabel("Name: ");
        l2.setFont(new Font("Literata", Font.BOLD, 13));
        l2.setBounds(109, 122, 75, 21);
        l2.setForeground(new Color(255, 255, 255));
        contentPane.add(l2);

        JLabel l3 = new JLabel("Security Question: ");
        l3.setFont(new Font("Literata", Font.BOLD, 13));
        l3.setBounds(109, 154, 125, 27);
        l3.setForeground(new Color(255, 255, 255));
        contentPane.add(l3);

        JLabel l4 = new JLabel( "Answer: ");
        l4.setFont(new Font("Literata", Font.BOLD, 13));
        l4.setBounds(109, 192, 104, 21);
        l4.setForeground(new Color(255, 255, 255));
        contentPane.add(l4);

        JLabel l5 = new JLabel( "Password: ");
        l5.setFont(new Font("Literata", Font.BOLD, 13));
        l5.setBounds(109, 224, 104, 21);
        l5.setForeground(new Color(255, 255, 255));
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setFont(new Font("Literata", Font.BOLD, 13));
        t1.setForeground(new Color(105, 105, 106));
        t1.setBounds(253, 88, 139, 20);
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setEditable(true);
        t2.setFont(new Font("Literata", Font.BOLD, 13));
        t2.setForeground(new Color(165, 42, 42));
        t2.setColumns(10);
        t2.setBounds(253, 123, 139, 20);
        contentPane.add(t2);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "What is your favorite color?", "What is your pet's name?", "Which is your favorite movie?" }));
        comboBox.setBounds(253, 155, 208, 20);
        contentPane.add(comboBox);


        t4 = new JTextField();
        t4.setFont(new Font("Literata", Font.BOLD, 13));
        t4.setForeground(new Color(205, 92, 92));
        t4.setColumns(10);
        t4.setBounds(253, 193, 139, 20);
        contentPane.add(t4);

        t5 = new JTextField();
        t5.setEditable(true);
        t5.setFont(new Font("Literata", Font.BOLD, 13));
        t5.setForeground(new Color(50, 205, 50));
        t5.setColumns(10);
        t5.setBounds(253, 225, 139, 20);
        contentPane.add(t5);

        b2 = new JButton("Retrieve");
        b2.addActionListener(this);
        b2.setFont(new Font("Literata", Font.BOLD, 12));
        b2.setBounds(412, 188, 85, 29);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Literata", Font.BOLD, 13));
        b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JLabel l9 = new JLabel("");
        ImageIcon i27 = new ImageIcon(ClassLoader.getSystemResource("Pictures/forgot2.jpg"));
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
            if (ae.getSource() == b1){
                String sql = "select * from account where Username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("Name "));
                    t3.setText(rs.getString("SecurityQuestion "));
                }
            }
            if (ae.getSource() == b2) {
                String sql = "select * from account where Answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t5.setText(rs.getString("Password"));
                }
            }
            if (ae.getSource() == b3) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
        }
    }

}

