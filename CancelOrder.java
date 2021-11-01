import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CancelOrder extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1,b2,b3;


    public static void main(String[] args) {
        new CancelOrder().setVisible(true);
    }

    public void delete() {
        try {
            conn con = new conn();
            String sql = "Delete from order_pizza where PizzaID=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, textField.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Cancel Order");
            else
                JOptionPane.showMessageDialog(null, "Error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }


    public CancelOrder() {
        super("Cancel Order ");

        setBounds(350,150,700,490);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("PizzaID: ");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(52, 52, 87, 24);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setForeground(new Color(105, 105, 105));
        textField.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField.setBounds(120, 56, 105, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblCustomerid = new JLabel("CustomerID:");
        lblCustomerid.setForeground(Color.WHITE);
        lblCustomerid.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCustomerid.setBounds(260, 52, 95, 24);
        contentPane.add(lblCustomerid);

        textField_1 = new JTextField();
        textField_1.setForeground(new Color(105, 105, 105));
        textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        textField_1.setBounds(360, 56, 105, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBounds(518, 52, 105, 29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JLabel lblBook = new JLabel("PizzaName:");
        lblBook.setForeground(Color.WHITE);
        lblBook.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBook.setBounds(52, 98, 85, 24);
        contentPane.add(lblBook);


        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setForeground(new Color(0, 100, 0));
        textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_2.setBounds(150, 102, 162, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(360, 98, 71, 24);
        contentPane.add(lblName);


        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setForeground(new Color(0, 100, 0));
        textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_3.setColumns(10);
        textField_3.setBounds(445, 102, 179, 20);
        contentPane.add(textField_3);


        JLabel lblCourse = new JLabel("Price: ");
        lblCourse.setForeground(Color.WHITE);
        lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourse.setBounds(52, 143, 87, 24);
        contentPane.add(lblCourse);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setForeground(new Color(0, 100, 0));
        textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_4.setColumns(10);
        textField_4.setBounds(150, 147, 162, 20);
        contentPane.add(textField_4);


        JLabel lblBranch = new JLabel("Mobile No:");
        lblBranch.setForeground(Color.WHITE);
        lblBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBranch.setBounds(360, 144, 80, 24);
        contentPane.add(lblBranch);


        textField_5 = new JTextField();
        textField_5.setForeground(new Color(0, 100, 0));
        textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(445, 147, 179, 20);
        contentPane.add(textField_5);


        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b2.setBounds(160, 210, 149, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        contentPane.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b3.setBounds(369, 210, 149, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        contentPane.add(b3);

        JPanel panel = new JPanel();


        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("Pictures/Cancel_Pizza.jpg"));
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
                String sql = "select * from order_pizza where CustomerID = ? and PizzaID =?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField_1.getText());
                st.setString(2, textField.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    textField_2.setText(rs.getString("PizzaName"));
                    textField_3.setText(rs.getString("Name"));
                    textField_4.setText(rs.getString("Price"));
                    textField_5.setText(rs.getString("MobileNo"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "Insert into cancel_order(PizzaID, CustomerID, PizzaName, Name, Price, MobileNo) values(?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField.getText());
                st.setString(2, textField_1.getText());
                st.setString(3, textField_2.getText());
                st.setString(4, textField_3.getText());
                st.setString(5, textField_4.getText());
                st.setString(6, textField_5.getText());


                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Processing...");
                    delete();
                } else
                    JOptionPane.showMessageDialog(null, "error");

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new HomePage().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}

