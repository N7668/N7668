import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;


    public Login() {
        super("Pizza Management System");

        setBounds(400, 200, 600, 405);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel l = new JLabel("");
        l.setForeground(Color.BLACK);
        l.setFont(new Font("Tahoma", Font.PLAIN, 25));
        l.setBounds(245, 10, 330, 56);
        contentPane.add(l);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(124, 95, 95, 24);
        l1.setForeground(new Color(255, 255, 255));
        l1.setBounds(170, 50, 100, 110);
        contentPane.add(l1);

        textField = new JTextField();
        textField.setBounds(240, 98, 157, 20);
        contentPane.add(textField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(124, 95, 95, 24);
        l2.setForeground(new Color(255, 255, 255));
        l2.setBounds(170, 110, 80, 85);
        contentPane.add(l2);

        passwordField = new JPasswordField();
        passwordField.setBounds(240, 144, 157, 20);
        contentPane.add(passwordField);

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(150, 200, 113, 39);
        contentPane.add(b1);

        b2 = new JButton("Sign Up");
        b2.addActionListener(this);

        b2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(319, 200, 113, 39);
        contentPane.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);

        b3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(212, 178, 128), new Color(5, 5, 5)));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(210, 280, 179, 39);
        contentPane.add(b3);

        JLabel l5 = new JLabel("Trouble in Login? ");
        l5.setFont(new Font("MS", Font.PLAIN, 15));
        l5.setForeground(new Color(255, 255, 255));
        l5.setBounds(90, 288, 130, 20);
        contentPane.add(l5);

        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("Pictures/Login_Pizza2.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l9 = new JLabel(i29);
        l9.setBounds(0, 0, 1000, 750);
        contentPane.add(l9);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Boolean status = false;
            try {
                conn con = new conn();
                String sql = "select * from account where Username=? and Password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new loading().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid login!");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            signup su = new signup();
            su.setVisible(true);
        }
        if (ae.getSource() == b3) {
            setVisible(false);
            forgot forgot = new forgot();
            forgot.setVisible(true);
        }
    }

    public static void main(String[] args) {

        new Login().setVisible(true);
    }

}
