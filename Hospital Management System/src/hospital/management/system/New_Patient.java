package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox combobox;

    JTextField textFeildNumber, textName, textFeildDisease, textFeildDeposit;

    JRadioButton r1,r2;

    Choice c1;

    JLabel date;

    JButton b1,b2;

    New_Patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icons/IMG-20240604-WA0017.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,150,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118,11,260,60);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID");
        labelID.setBounds(35,71,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,20));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        combobox = new JComboBox(new String[]{"Passport","id Card","Driving License"});
        combobox.setBounds(250,65,170,20);
        combobox.setBackground(new Color(3,45,48));
        combobox.setForeground(Color.WHITE);
        combobox.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(combobox);

        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,20));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFeildNumber = new JTextField();
        textFeildNumber.setBounds(250,105,170,20);
        panel.add(textFeildNumber);

        JLabel labelName1 = new JLabel("Name");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(250,151,170,20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,20));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(250,191,100,20);
        r1.setBackground(new Color(109,164,170));
        r1.setFont(new Font("Tahoma",Font.BOLD,20));
        r1.setForeground(Color.WHITE);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(350,191,100,20);
        r2.setBackground(new Color(109,164,170));
        r2.setFont(new Font("Tahoma",Font.BOLD,20));
        r2.setForeground(Color.WHITE);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,20));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFeildDisease = new JTextField();
        textFeildDisease.setBounds(250,231,170,20);
        panel.add(textFeildDisease);

        JLabel labelRoom = new JLabel("Room");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,20));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);


        c1 = new Choice();
        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        c1.setBounds(250,274,170,20);
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.WHITE);
        c1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(c1);



        JLabel labelDate = new JLabel("Time");
        labelDate.setBounds(35,314,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,20));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel(""+date1);
        date.setBounds(225,314,300,14);
        date.setFont(new Font("Tahoma",Font.BOLD,20));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35,351,200,22);
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,20));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        textFeildDeposit = new JTextField();
        textFeildDeposit.setBounds(250,351,170,20);
        panel.add(textFeildDeposit);

        b1 = new JButton("Add");
        b1.setBounds(50,400,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(200,400,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);


        setSize(850,550);
        setLayout(null);
        setLocation(450,450);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            con c = new con();
            String radioBTN = null;
            if(r1.isSelected()) {
                radioBTN = "Male";
            }else if(r2.isSelected()){
                radioBTN ="Female";
            }

            String s1= (String) combobox.getSelectedItem();
            String s2 = textFeildNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFeildDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFeildDeposit.getText();

            try{
                String q = "insert into patient_info(ID, Number, Name, Gender, Patient_Disease, Room_Number, Time, Deposit) values(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = c.connection.prepareStatement(q);
                preparedStatement.setString(1, s1);
                preparedStatement.setString(2, s2);
                preparedStatement.setString(3, s3);
                preparedStatement.setString(4, s4);
                preparedStatement.setString(5, s5);
                preparedStatement.setString(6, s6);
                preparedStatement.setString(7, s7);
                preparedStatement.setString(8, s8);
                preparedStatement.executeUpdate();

                String q1 = "update room set Availability = 'Occupied' where room_no = "+s6;
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Patient Added Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
     new New_Patient();
    }


}
