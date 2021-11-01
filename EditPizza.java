import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditPizza extends JFrame implements ActionListener{

       private JPanel contentPane;
       private JTable table;
       private JTextField search;
       private JButton b1, b2, b3;

       public static void main(String[] args) {
              new EditPizza().setVisible(true);
       }

       public void Pizza() {
              try {
                     conn con =  new conn();
                     String sql = "select * from add_pizza";
                     PreparedStatement st = con.c.prepareStatement(sql);
                     ResultSet rs = st.executeQuery();

                     table.setModel(DbUtils.resultSetToTableModel(rs));
                     rs.close();
                     st.close();
                     con.c.close();
              } catch (Exception e){
              }
       }

       public EditPizza() {
              setBounds(350, 200, 890, 475);
              contentPane = new JPanel();
              contentPane.setBackground(Color.WHITE);
              contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
              setContentPane(contentPane);
              contentPane.setLayout(null);

              JScrollPane scrollPane = new JScrollPane();
              scrollPane.setBounds(79, 133, 771, 282);
              contentPane.add(scrollPane);

              table = new JTable();
              table.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent arg0) {
                            int row = table.getSelectedRow();
                            search.setText(table.getModel().getValueAt(row, 1).toString());
                     }
              });
              table.setBackground(new Color(240, 248, 255));
              table.setForeground(Color.DARK_GRAY);
              table.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
              scrollPane.setViewportView(table);

              JButton b1 = new JButton("Search");
              b1.addActionListener(this);
              b1.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));

              b1.setForeground(Color.WHITE);
              b1.setBackground(Color.BLACK);

              b1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
              b1.setBounds(564, 89, 138, 30);    //y=89 height=133
              contentPane.add(b1);

              JButton b2 = new JButton("Delete");
              b2.addActionListener(this);
              b2.setForeground(Color.WHITE);
              b2.setBackground(Color.BLACK);
              b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
              b2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
              b2.setBounds(712, 89, 138, 30);
              contentPane.add(b2);

              JLabel l1 = new JLabel("Edit Pizza:");
              l1.setForeground(new Color(107, 148, 35));
              l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
              l1.setBounds(200, 15, 400, 47);
              contentPane.add(l1);

              search = new JTextField();
              search.setBackground(new Color(255, 240, 245));
              search.setBorder(new LineBorder(new Color(255, 185, 188), 2, true));
              search.setForeground(new Color(47, 79, 79));
              search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
              search.setBounds(189, 89, 357, 33);
              contentPane.add(search);
              search.setColumns(10);

              JLabel l3 = new JLabel("Back");
              l3.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent e) {
                            setVisible(false);
                            HomePage home = new HomePage();
                            home.setVisible(true);
                     }
              });
              l3.setForeground(Color.GRAY);
              l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
              ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource(""));
              Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
              ImageIcon i9 = new ImageIcon(i8);
              l3.setIcon(i9);
              l3.setBounds(97, 89, 72, 33);
              contentPane.add(l3);



              JLabel l9 = new JLabel("");
              ImageIcon i27 = new ImageIcon(ClassLoader.getSystemResource(""));
              Image i28 = i27.getImage().getScaledInstance(1000, 750, Image.SCALE_DEFAULT);
              ImageIcon i29 = new ImageIcon(i28);
              l9 = new JLabel(i29);
              l9.setBounds(0, 0, 1000, 750);
              contentPane.add(l9);
       }

       public void actionPerformed(ActionEvent ae) {
              try {
                     conn con = new conn();
                     if(ae.getSource() == b1) {
                            String sql = "select * from  add_pizza where concat(PizzaName, PizzaID) like ?";
                            PreparedStatement st = con.c.prepareStatement(sql);
                            st.setString(1, "%" + search.getText() + "%");
                            ResultSet rs = st.executeQuery();

                            table.setModel(DbUtils.resultSetToTableModel(rs));
                            rs.close();
                            st.close();

                     }
                     if(ae.getSource() == b2){
                            String sql = "delete from add_pizza where PizzaName = '" + search.getText() + "'";
                            PreparedStatement st = con.c.prepareStatement(sql);

                            JDialog.setDefaultLookAndFeelDecorated(true);
                            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.NO_OPTION) {

                            } else if (response == JOptionPane.YES_OPTION) {
                                   int rs = st.executeUpdate();
                                   JOptionPane.showMessageDialog(null, "Deleted !!");
                            } else if (response == JOptionPane.CLOSED_OPTION) {

                            }
                            st.close();


                     }

                     con.c.close();
              }catch(Exception e){

              }
       }
}

