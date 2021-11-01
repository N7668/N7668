import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddPizzaa extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b1,b2;
    JComboBox comboBox, comboBox_1;

    public static void main(String[] args) {

        new AddPizzaa().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(1000 + 1));
    }

    public AddPizzaa() {
        super("Add Pizza");

        setBounds(400,200,600,450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l5 = new JLabel("Pizza ID:");
        l5.setForeground(new Color(255, 255, 255));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(73, 49, 90, 22);
        contentPane.add(l5);

        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t1.setBounds(169, 51, 198, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel l1 = new JLabel("Pizza Name:");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(73, 94, 90, 22);
        contentPane.add(l1);

        t2 = new JTextField();
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t2.setColumns(10);
        t2.setBounds(169, 96, 198, 20);
        contentPane.add(t2);


        JLabel l2 = new JLabel("Categories:");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(73, 139, 90, 22);
        contentPane.add(l2);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Veg", "Non-Veg" }));
        comboBox.setBounds(169, 141, 198, 20);
        contentPane.add(comboBox);

        JLabel l6 = new JLabel("Available in:");
        l6.setForeground(new Color(255, 255, 255));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(73, 184, 90, 22);
        contentPane.add(l6);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Regular", "Medium", "Large", "Regular & Medium", "Medium & Large", "All"}));
        comboBox_1.setBounds(169, 186, 198, 20);
        contentPane.add(comboBox_1);


        JLabel l3 = new JLabel("Description:");
        l3.setForeground(new Color(255, 255, 255));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(75, 229, 90, 22);
        contentPane.add(l3);

        t3 = new JTextField();
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(169, 231, 198, 40);
        contentPane.add(t3);


        JLabel l4 = new JLabel("Price:");
        l4.setForeground(new Color(255, 255, 255));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(73, 278, 90, 22);
        contentPane.add(l4);

        t4 = new JTextField();
        t4.setForeground(new Color(47, 79, 79));
        t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(169, 285, 198, 20);
        contentPane.add(t4);


        b1 = new JButton("Update");
        b1.addActionListener(this);
        b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b1.setBounds(102, 340, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Reset");
        b2.addActionListener(this);
        b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
        b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        b2.setBounds(212, 340, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        contentPane.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        random();


        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("Pictures/Pizza_Background3.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 740, Image.SCALE_FAST);
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
                String sql = "insert into add_pizza(PizzaID, PizzaName, Categories, AvailableIn, Description, Price) values(?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, (String) comboBox.getSelectedItem());
                st.setString(4, (String) comboBox_1.getSelectedItem());
                st.setString(5, t3.getText());
                st.setString(6, t4.getText());


                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                else
                    JOptionPane.showMessageDialog(null, "Error");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                //t6.setText("");
                st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new HomePage().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }

}
