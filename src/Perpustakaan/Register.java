package Perpustakaan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Register extends JFrame implements ActionListener {

    ImageIcon image;
    JLabel judul, username, password, uPassword, nLengkap, register;
    JTextField textUsername, textNl;
    JPasswordField textPassword, textUp;
    JButton button;

    Register() {

        this.setTitle("Register");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        image = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\lib2.png");
        this.setIconImage(image.getImage());

        judul = new JLabel(image);
        judul.setBounds(50, 70, 300, 100);
        judul.setText("Aplikasi Perpustakaan");
        judul.setIcon(image);

        judul.setForeground(Color.white);

        judul.setHorizontalTextPosition(JLabel.CENTER);
        judul.setVerticalTextPosition(JLabel.BOTTOM);

        //username
        username = new JLabel();
        username.setText("Username");
        username.setBounds(128, 200, 65, 20);
        username.setForeground(Color.gray);
        this.add(username);

        textUsername = new JTextField();
        textUsername.setBounds(117, 197, 174, 27);
        this.add(textUsername);

        //password
        password = new JLabel();
        password.setText("Password");
        password.setBounds(128, 245, 60, 20);
        password.setForeground(Color.gray);
        this.add(password);

        textPassword = new JPasswordField();
        textPassword.setBounds(117, 241, 174, 27);
        this.add(textPassword);

        //Ulangi Password
        uPassword = new JLabel();
        uPassword.setText("Ulangi Password");
        uPassword.setBounds(128, 290, 100, 20);
        uPassword.setForeground(Color.gray);
        this.add(uPassword);

        textUp = new JPasswordField();
        textUp.setBounds(117, 288, 174, 27);
        this.add(textUp);

        nLengkap = new JLabel();
        nLengkap.setText("Nama Lengkap");
        nLengkap.setBounds(128, 337, 90, 20);
        nLengkap.setForeground(Color.gray);
        this.add(nLengkap);

        textNl = new JTextField();
        textNl.setBounds(117, 335, 174, 27);
        this.add(textNl);

        button = new JButton("REGISTER");
        button.setForeground(Color.black);
        button.setFocusable(false);
        button.setBounds(140, 380, 116, 34);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button.setBackground(Color.white);
        button.addActionListener(this);

        this.add(button);

        register = new JLabel();
        register.setText("Login");
        register.setBounds(180, 425, 56, 15);
        register.setForeground(Color.red);

        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                Login log = new Login();
                log.setVisible(true);
            }
        });

        this.add(register);

        this.add(judul);
        this.getContentPane().setBackground(Color.ORANGE);

        //       
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String usename = textUsername.getText();
        String pass = String.valueOf(textPassword.getPassword());
        String upass = String.valueOf(textUp.getPassword());
        String name = textNl.getText();

        PreparedStatement ps;
        String sql = "INSERT INTO `tabel_login`(`username`, `password`, `fullname`) VALUES (?,?,?)";

        try {
            ps = DBconnect.getConnection().prepareStatement(sql);

            ps.setString(1, usename);
            ps.setString(2, pass);
            ps.setString(3, name);

            if (usename.isEmpty() && pass.isEmpty() && upass.isEmpty() && name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Semua Data", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(usename.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Username", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Password", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(upass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Ulangi Password", "Message", JOptionPane.ERROR_MESSAGE);
            } else if(name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi Nama Panjang", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (!pass.equals(upass)) {
                JOptionPane.showMessageDialog(null, "Password Salah", "Message", JOptionPane.ERROR_MESSAGE);
            } else if (ps.executeUpdate() > 0) {
                dispose();
                new Login().setVisible(true);
                JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aktifkan Service MySQL Menggunakan XAMPP", "", JOptionPane.WARNING_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }
}
