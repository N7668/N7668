import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaManagementSystem extends JFrame implements ActionListener{

       JLabel l1;
       JButton b1;
private JPanel panel;

       public PizzaManagementSystem() {

              setBounds(400, 200, 580, 405);
              setLayout(null);

              panel = new JPanel();
              panel.setBorder(new EmptyBorder(5, 5, 5, 5));
              setBackground(new Color(169, 169, 169));
              setContentPane(panel);
              panel.setBackground(Color.white);
              panel.setLayout(null);

              JLabel l5 = new JLabel("");
              l5.setBounds(160, 20, 400, 36);
              l5.setForeground(new Color(255, 160, 0));
              l5.setFont(new Font("Acne", Font.CENTER_BASELINE, 20));
              panel.add(l5);

              l1 = new JLabel("");
              ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Pictures/Pizza_Main2.jpg"));
              Image i3 = i1.getImage().getScaledInstance(750, 400, Image.SCALE_DEFAULT);
              ImageIcon i2 = new ImageIcon(i3);
              l1 = new JLabel(i2);
              l1.setBounds(0, 0, 750, 390);


              b1 = new JButton("Next");
              b1.addActionListener(this);
              b1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)));
              b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
              b1.setForeground(Color.BLACK);// b1.setBackground(Color.WHITE);
              b1.setBounds(149, 200, 113, 39);
              panel.add(b1);
              b1.setBounds(220,250,120,40);


              l1.add(b1);
              add(l1);
              b1.addActionListener(this);
       }

       @Override
       public void actionPerformed(ActionEvent ae){
              new Login().setVisible(true);
              this.setVisible(false);
       }

       public static void main(String[] args) {
              PizzaManagementSystem window = new PizzaManagementSystem();
              window.setVisible(true);
       }

}
