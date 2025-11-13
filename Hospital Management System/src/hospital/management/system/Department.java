package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(90 ,156,163));
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(table);

        try{
            con c = new con();
            String q = "select * from Department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setBounds(130,10,105,20);
        panel.add(label1);

        JLabel label2 = new JLabel("Phone no");
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setBounds(420,10,105,20);
        panel.add(label2);

        JButton b1 =new JButton("Back");
        b1.setBounds(300,400,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();

    }
}
