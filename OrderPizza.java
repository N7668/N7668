import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderPizza extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private JButton b1,b2,b3,b4;
    private JComboBox comboBox, comboBox_1, comboBox_2;

    public static void main(String[] args) {
        new OrderPizza().setVisible(true);

    }

    public OrderPizza() {
        super("Order Pizza ");
        setBounds(285, 180, 780, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Pizza ID:");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(new Color(255, 255, 255));
        l1.setBounds(47, 63, 100, 23);
        contentPane.add(l1);

        t1 = new JTextField();
        t1.setForeground(new Color(19, 18, 18));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(148, 66, 86, 20);
        contentPane.add(t1);


        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b1.setBounds(255, 59, 100, 30);
        contentPane.add(b1);

        JLabel l2 = new JLabel("Pizza Name:");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(47, 122, 100, 23);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(19, 18, 18));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setBounds(148, 122, 208, 20);
        contentPane.add(t2);
        t2.setColumns(10);




        JLabel l5 = new JLabel("Description:");
        l5.setForeground(new Color(255, 255, 255));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(47, 180, 100, 23);
        contentPane.add(l5);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setForeground(new Color(19, 18, 18));
        t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(148, 180, 208, 70);
        contentPane.add(t5);


        JLabel l6 = new JLabel("Price:");
        l6.setForeground(new Color(255, 255, 255));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(47, 284, 100, 23);
        contentPane.add(l6);

        t6 = new JTextField();
        t6.setEditable(false);
        t6.setForeground(new Color(19, 18, 18));
        t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(148, 286, 208, 20);
        contentPane.add(t6);



        JLabel l8 = new JLabel("Customer ID:");
        l8.setForeground(new Color(255, 255, 255));
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setBounds(400, 63, 100, 23);
        contentPane.add(l8);

        t8 = new JTextField();
        t8.setForeground(new Color(19, 18, 18));
        t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t8.setColumns(10);
        t8.setBounds(508, 66, 86, 20);
        contentPane.add(t8);


        b2 = new JButton("Search");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b2.setBounds(612, 59, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JLabel l9 = new JLabel("Name:");
        l9.setForeground(new Color(255, 255, 255));
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setBounds(400, 122, 100, 23);
        contentPane.add(l9);

        t9 = new JTextField();
        t9.setForeground(new Color(19, 18, 18));
        t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t9.setEditable(false);
        t9.setColumns(10);
        t9.setBounds(508, 122, 208, 20);
        contentPane.add(t9);


        JLabel l11 = new JLabel("Password:");
        l11.setForeground(new Color(255, 255, 255));
        l11.setFont(new Font("Tahoma", Font.BOLD, 14));
        l11.setBounds(400, 180, 100, 23);
        contentPane.add(l11);

        t11 = new JTextField();
        t11.setForeground(new Color(19, 18, 18));
        t11.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t11.setEditable(false);
        t11.setColumns(10);
        t11.setBounds(508, 180, 208, 20);
        contentPane.add(t11);


        JLabel l12 = new JLabel("Mobile No:");
        l12.setForeground(new Color(255, 255, 255));
        l12.setFont(new Font("Tahoma", Font.BOLD, 14));
        l12.setBounds(400, 233, 100, 23);
        contentPane.add(l12);

        t12 = new JTextField();
        t12.setForeground(new Color(19, 18, 18));
        t12.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t12.setEditable(false);
        t12.setColumns(10);
        t12.setBounds(508, 236, 208, 20);
        contentPane.add(t12);


        JLabel l13 = new JLabel("Email ID:");
        l13.setForeground(new Color(255, 255, 255));
        l13.setFont(new Font("Tahoma", Font.BOLD, 14));
        l13.setBounds(400, 284, 100, 23);
        contentPane.add(l13);

        t13 = new JTextField();
        t13.setForeground(new Color(19, 18, 18));
        t13.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t13.setEditable(false);
        t13.setColumns(10);
        t13.setBounds(508, 286, 208, 20);
        contentPane.add(t13);



        b3 = new JButton("Order");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b3.setBounds(238, 390, 118, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        b4 = new JButton("Back");
        b4.addActionListener(this);
        b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b4.setBounds(400, 390, 118, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        contentPane.add(b4);


        JLabel l10 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("Pictures/Order_Pizza1.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 750,Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l10 = new JLabel(i29);
        l10.setBounds(0, 0, 1000, 750);
        contentPane.add(l10);


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from add_pizza where PizzaID = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("PizzaName"));
                    t5.setText(rs.getString("Description"));
                    t6.setText(rs.getString("Price"));

                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "select * from add_customer where CustomerID = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t8.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t9.setText(rs.getString("Name"));
                    t11.setText(rs.getString("Password"));
                    t12.setText(rs.getString("MobileNo"));
                    t13.setText(rs.getString("EmailID"));


                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b3){
                try{
                    String sql = "insert into order_pizza(PizzaID, CustomerID, PizzaName, Description, Price, Name, Password, MobileNo, EmailID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t8.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, t5.getText());
                    st.setString(5, t6.getText());
                    st.setString(6, t9.getText());
                    st.setString(7, t11.getText());
                    st.setString(8, t12.getText());
                    st.setString(9, t13.getText());


                    int i = st.executeUpdate();
                    if (i > 0)
                        JOptionPane.showMessageDialog(null, "Your Order has been placed !");
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new HomePage().setVisible(true);

            }

            con.c.close();
        }catch(Exception e){

        }
    }
}

