package Perpustakaan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Login extends JFrame implements ActionListener {           

    ImageIcon image;
    JLabel judul, username, password;   
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
        button = new JButton();
        button.setText("Login");
        button.setForeground(Color.black);
        button.setFocusable(false);
        button.setBounds(150, 380, 80, 20);
        button.addActionListener(this);
        button.setBackground(Color.white);
        this.add(button);

        this.add(judul);
        this.getContentPane().setBackground(Color.ORANGE);        

        //       
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            String username = "admin";
            String password = "pass";
            if (textUsername.getText().equals(username) && textPassword.getText().equals(password)) {
                PageLibrary pageLibrary = new PageLibrary();
                pageLibrary.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username dan Password Salah", "Error", JOptionPane.ERROR_MESSAGE);                
            }

        }

    }

}
