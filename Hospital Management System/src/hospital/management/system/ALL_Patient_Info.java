package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ALL_Patient_Info extends JFrame {

    ALL_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(table);

        try{
            con c = new con();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setBounds(31,10,105,25);
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setBounds(130,10,105,25);
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setFont(new Font("Tahoma",Font.BOLD,16));
        label3.setBounds(270,10,105,25);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setFont(new Font("Tahoma",Font.BOLD,16));
        label4.setBounds(360,10,105,25);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setFont(new Font("Tahoma",Font.BOLD,16));
        label5.setBounds(480,10,105,25);
        panel.add(label5);

        JLabel label7 = new JLabel("DRoom");
        label7.setFont(new Font("Tahoma",Font.BOLD,16));
        label7.setBounds(600,10,105,25);
        panel.add(label7);

        JLabel label8 = new JLabel("Time");
        label8.setFont(new Font("Tahoma",Font.BOLD,16));
        label8.setBounds(700,10,105,25);
        panel.add(label8);

        JLabel label6 = new JLabel("Deposit");
        label6.setFont(new Font("Tahoma",Font.BOLD,16));
        label6.setBounds(790,10,105,25);
        panel.add(label6);

        JButton b1 =new JButton("Back");
        b1.setBounds(400,500,100,30);
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
        setSize(900,600);
        setLayout(null);
        setLocation(300,300);
        setVisible(true);

    }



    public static void main(String[] args) {
        new ALL_Patient_Info();
    }
}
