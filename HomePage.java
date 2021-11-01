import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton b1, b2, b3, b4, b5,b6;

    public static void main(String[] args) {

        new HomePage().setVisible(true);
    }

    public HomePage() {

        setBounds(200, 15, 940, 800);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
        menuBar.setBackground(Color.WHITE);
        menuBar.setBounds(0, 10, 1000, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setBackground(new Color(211, 211, 211));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(105, 105, 105));
        mntmExit.setBackground(new Color(211, 211, 211));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);


        JMenu mnRecord = new JMenu("Record");
        mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));


        JMenuItem BookDetails = new JMenuItem("Pizza Details");
        BookDetails.addActionListener(this);
        BookDetails.setBackground(new Color(211, 211, 211));
        BookDetails.setForeground(Color.DARK_GRAY);
        mnRecord.add(BookDetails);

        JMenuItem Student_info = new JMenuItem("Customer Details");
        Student_info.setBackground(new Color(211, 211, 211));
        Student_info.setForeground(Color.DARK_GRAY);
        Student_info.addActionListener(this);
        mnRecord.add(Student_info);

        menuBar.add(mnRecord);
        menuBar.add(mnExit);


        JLabel l1 = new JLabel("Pizza Management System");
        l1.setForeground(new Color(204, 51, 102));
        l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        l1.setBounds(268, 30, 701, 80);
        contentPane.add(l1);

        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Pizza_Homepage.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 145, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(78, 140, 152, 145);
        contentPane.add(l2);

        JLabel l3 = new JLabel("");
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Statistics.png"));
        Image i5 = i4.getImage().getScaledInstance(190, 180, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(352, 140, 225, 168);
        contentPane.add(l3);

        JLabel l4 = new JLabel("");
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/eatpizza.png"));
        Image i8 = i7.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(670, 140, 225, 152);
        contentPane.add(l4);

        b1 = new JButton("Add Pizza");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 320, 159, 44);
        contentPane.add(b1);

        b2 = new JButton("Statistics");
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(400, 320, 139, 44);
        contentPane.add(b2);

        b3 = new JButton("Add Customer");
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(700, 320, 167, 44);
        contentPane.add(b3);


        b4 = new JButton("Order Pizza");
        b4.addActionListener(this);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(195, 620, 143, 41);
        contentPane.add(b4);

        b5 = new JButton("Cancel Pizza");
        b5.addActionListener(this);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(550, 620, 159, 41);
        contentPane.add(b5);



        JLabel l5 = new JLabel("");
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/Order_Homepage.png"));
        Image i11 = i10.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(200, 440, 159, 163);
        contentPane.add(l5);

        JLabel l6 = new JLabel("");
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/Cancel_Homepage.png"));
        Image i14 = i13.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(560, 440, 137, 152);
        contentPane.add(l6);



        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource("icons/Cream_Homepage.jpg"));
        Image i28 = i27.getImage().getScaledInstance(1000, 750,Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l9 = new JLabel(i29);
        l9.setBounds(0, 0, 1000, 750);
        contentPane.add(l9);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Logout")) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (msg.equals("Exit")) {
            System.exit(ABORT);

        } else if (msg.equals("Read Me")) {

        }  else if (msg.equals("Pizza Details")) {
            setVisible(false);
            new EditPizza().setVisible(true);
        } else if (msg.equals("Customer Details")) {
            setVisible(false);
            new FeedBack().setVisible(true);

        }

        if (ae.getSource() == b1) {
            this.setVisible(false);
            new AddPizzaa().setVisible(true);
        }
        if (ae.getSource() == b2) {
            this.setVisible(false);
            new Statistics().setVisible(true);
        }
        if (ae.getSource() == b3) {
            this.setVisible(false);
            new AddCustomer().setVisible(true);
        }
        if (ae.getSource() == b4) {
            this.setVisible(false);
            new OrderPizza().setVisible(true);
        }
        if (ae.getSource() == b5) {
            this.setVisible(false);
            new CancelOrder().setVisible(true);

        }

    }
}

