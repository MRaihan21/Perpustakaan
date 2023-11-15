package Perpustakaan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Login extends JFrame implements ActionListener {
    
    Connection con = null; 

    ImageIcon image;
    JLabel judul, username, password, register;
    JTextField textUsername, textPassword;
    JButton button;

    Login() {

        //frame
        this.setTitle("Login");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //image
        image = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\lib2.png");
        this.setIconImage(image.getImage());

        //label tittle and image
        judul = new JLabel();
        judul.setText("Aplikasi Perpustakaan");
        judul.setIcon(image);

        judul.setForeground(Color.white);
        judul.setHorizontalTextPosition(JLabel.CENTER);
        judul.setVerticalTextPosition(JLabel.BOTTOM);
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setVerticalAlignment(JLabel.CENTER);

        //username
        username = new JLabel();
        username.setText("Username");
        username.setBounds(130, 320, 90, 20);
        username.setForeground(Color.gray);
        this.add(username);

        textUsername = new JTextField();
        textUsername.setBounds(115, 320, 160, 20);
        this.add(textUsername);

        //password
        password = new JLabel();
        password.setText("Password");
        password.setBounds(130, 350, 90, 20);
        password.setForeground(Color.gray);
        this.add(password);

        textPassword = new JPasswordField();
        textPassword.setBounds(115, 350, 160, 20);
        this.add(textPassword);

        //button        
        button = new JButton("Login");
        button.setForeground(Color.black);
        button.setFocusable(false);
        button.setBackground(Color.white);
        button.setBounds(150, 380, 80, 20);
        //lambda
        button.addActionListener((ActionEvent e) -> {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_perpustakaan", "root", "");
                
                Statement stm = con.createStatement();
                
                String username1 = textUsername.getText();
                String password1 = textPassword.getText();
                String sql = "SELECT * FROM tabel_login WHERE username='" + username1 + "' AND password='" + password1 + "'";
                
                ResultSet rs = stm.executeQuery(sql);
                
                if (username1.equals("") && password1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Username dan Password", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (password1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Password", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (username1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Isi Username", "Message", JOptionPane.ERROR_MESSAGE);
                } else if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + username1);
                    dispose();
                    PageLibrary pagelibrary = new PageLibrary();
                    pagelibrary.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Username & Password Salah", "Message", JOptionPane.ERROR_MESSAGE);
                }
                //catch sql
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Aktifkan Service MySQL Menggunakan XAMPP", "", JOptionPane.WARNING_MESSAGE);
                System.out.println(ex.getMessage());
            }
        });
        this.add(button);

        register = new JLabel();
        register.setText("Register a new account");
        register.setBounds(130, 415, 180, 15);
        register.setForeground(Color.red);

        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                Register regis = new Register();
                regis.setVisible(true);
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
        
    }
}
