import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Statistics extends JFrame{

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;

    public static void main(String[] args) {
        new Statistics().setVisible(true);

    }

    public void OrderPizza() {
        try {
            conn con =  new conn();
            String sql = "select * from order_pizza";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void CancelOrder() {
        try {
            conn con = new conn();
            String sql = "select * from cancel_order";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Statistics() {
        super("Statistics");
        setBounds(280, 80, 800, 630);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 51, 708, 217);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(224, 255, 255));
        table.setForeground(new Color(128, 128, 0));
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        scrollPane.setViewportView(table);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Order-Pizza-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
        panel.setForeground(new Color(0, 128, 128));
        panel.setBounds(26, 36, 737, 240);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        JLabel l1 = new JLabel("Back");
        l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                setVisible(false);
                HomePage home = new HomePage();
                home.setVisible(true);
            }
        });
        l1.setForeground(new Color(204, 0, 10));
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
        l1.setBounds(690, 13, 96, 27);
        contentPane.add(l1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(40, 316, 717, 217);
        contentPane.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setBackground(new Color(204, 255, 255));
        table_1.setForeground(new Color(153, 51, 0));
        table_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        scrollPane_1.setViewportView(table_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Cancel-Order-Details",
                TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 128, 128)));
        panel_1.setBounds(22, 299, 741, 240);
        panel_1.setBackground(Color.WHITE);
        contentPane.add(panel_1);


        OrderPizza();
        CancelOrder();

        JLabel l9 = new JLabel("");
        ImageIcon i27  = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i28 = i27.getImage().getScaledInstance(1000, 750,Image.SCALE_DEFAULT);
        ImageIcon i29 = new ImageIcon(i28);
        l9 = new JLabel(i29);
        l9.setBounds(0, 0, 1000, 750);
        contentPane.add(l9);


    }
}

