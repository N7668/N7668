import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;

    public static void main(String[] args) {
        new loading().setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new HomePage().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public loading() {


        th = new Thread((Runnable) this);


        setBounds(400,200,600,405);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbLibraryManagementSystem = new JLabel("");
        lbLibraryManagementSystem .setForeground(new Color(2, 52, 50));
        lbLibraryManagementSystem .setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbLibraryManagementSystem.setBounds(220, 56, 500, 35);
        contentPane.add(lbLibraryManagementSystem);


        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 160, 300, 25);
        contentPane.add(progressBar);



        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(24, 3, 3));
        lblNewLabel_2.setBounds(220, 200, 150, 20);
        contentPane.add(lblNewLabel_2);


        JLabel l6 = new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("Pictures/Pizza_Loading.gif"));
        Image i14 = i13.getImage().getScaledInstance(600, 420,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(0, 0, 600, 400);
        contentPane.add(l6);
        setUploading();
    }
}



