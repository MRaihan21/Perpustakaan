package Perpustakaan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PageLibrary extends JFrame implements ActionListener {

    ImageIcon images;
    JLabel tittle, nama, pekerjaan, pendter, jk, alamat;
    JTextField textNama;
    JTextArea textAlamat;
    JButton buttonSmpn, ButtonRst;
    JRadioButton pn, ps, tnp, pljr, mhs, lny, sd, smp, sma, d1, d2, d3, s1, s2, s3, lk, pr;
    ButtonGroup group, group2, group3;

    public PageLibrary() {

        //frame
        this.setTitle("Buku Tamu");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //image
        images = new ImageIcon("C:\\Users\\A C E R\\Downloads\\JavaPicture\\lib2.png");
        this.setIconImage(images.getImage());

        //label
        tittle = new JLabel("BUKU TAMU");
        tittle.setBounds(353, 57, 193, 39);
        tittle.setForeground(Color.white);
        tittle.setFont(new Font("Inter", Font.BOLD, 32));
        this.add(tittle);

        nama = new JLabel();
        nama.setText("Nama Pengunjung");
        nama.setBounds(66, 169, 165, 30);
        nama.setFont(new Font("Inter", Font.BOLD, 18));
        this.add(nama);

        textNama = new JTextField();
        textNama.setBounds(306, 166, 410, 30);
        textNama.grabFocus();
        this.add(textNama);

        pekerjaan = new JLabel();
        pekerjaan.setText("Pekerjaan");
        pekerjaan.setBounds(66, 245, 90, 25);
        pekerjaan.setFont(new Font("Inter", Font.BOLD, 18));
        this.add(pekerjaan);

        pn = new JRadioButton("Pegawai Negeri");
        pn.setBounds(306, 234, 140, 30);
        pn.setBackground(Color.orange);
        pn.setFocusPainted(false);

        ps = new JRadioButton("Pegawai Swasta");
        ps.setBounds(450, 234, 140, 30);
        ps.setBackground(Color.orange);
        ps.setFocusPainted(false);

        tnp = new JRadioButton("TNI / POLRI");
        tnp.setBounds(600, 234, 140, 30);
        tnp.setBackground(Color.orange);
        tnp.setFocusPainted(false);

        pljr = new JRadioButton("Pelajar");
        pljr.setBounds(306, 267, 140, 30);
        pljr.setBackground(Color.orange);
        pljr.setFocusPainted(false);

        mhs = new JRadioButton("Mahasiwa");
        mhs.setBounds(450, 267, 140, 30);
        mhs.setBackground(Color.orange);
        mhs.setFocusPainted(false);

        lny = new JRadioButton("Lainnya");
        lny.setBounds(600, 267, 140, 30);
        lny.setBackground(Color.orange);
        lny.setFocusPainted(false);

        group = new ButtonGroup();
        group.add(pn);
        group.add(ps);
        group.add(tnp);
        group.add(pljr);
        group.add(mhs);
        group.add(lny);

        this.add(pn);
        this.add(ps);
        this.add(tnp);
        this.add(pljr);
        this.add(mhs);
        this.add(lny);

        pendter = new JLabel();
        pendter.setText("Pendidikan Terakhir");
        pendter.setBounds(66, 332, 190, 25);
        pendter.setFont(new Font("Inter", Font.BOLD, 18));
        this.add(pendter);

        sd = new JRadioButton("SD");
        sd.setBounds(306, 332, 140, 30);
        sd.setBackground(Color.orange);
        sd.setFocusPainted(false);

        smp = new JRadioButton("SMP");
        smp.setBounds(450, 332, 140, 30);
        smp.setBackground(Color.orange);
        smp.setFocusPainted(false);

        sma = new JRadioButton("SMA");
        sma.setBounds(600, 332, 140, 30);
        sma.setBackground(Color.orange);
        sma.setFocusPainted(false);

        d1 = new JRadioButton("D1");
        d1.setBounds(306, 365, 140, 30);
        d1.setBackground(Color.orange);
        d1.setFocusPainted(false);

        d2 = new JRadioButton("D2");
        d2.setBounds(450, 365, 140, 30);
        d2.setBackground(Color.orange);
        d2.setFocusPainted(false);

        d3 = new JRadioButton("D3");
        d3.setBounds(600, 365, 140, 30);
        d3.setBackground(Color.orange);
        d3.setFocusPainted(false);

        s1 = new JRadioButton("S1");
        s1.setBounds(306, 398, 140, 30);
        s1.setBackground(Color.orange);
        s1.setFocusPainted(false);

        s2 = new JRadioButton("S2");
        s2.setBounds(450, 398, 140, 30);
        s2.setBackground(Color.orange);
        s2.setFocusPainted(false);

        s3 = new JRadioButton("S3");
        s3.setBounds(600, 398, 140, 30);
        s3.setBackground(Color.orange);
        s3.setFocusPainted(false);

        group2 = new ButtonGroup();
        group2.add(sd);
        group2.add(smp);
        group2.add(sma);
        group2.add(d1);
        group2.add(d2);
        group2.add(d3);
        group2.add(s1);
        group2.add(s2);
        group2.add(s3);

        this.add(sd);
        this.add(smp);
        this.add(sma);
        this.add(d1);
        this.add(d2);
        this.add(d3);
        this.add(s1);
        this.add(s2);
        this.add(s3);

        jk = new JLabel();
        jk.setText("Jenis Kelamin");
        jk.setBounds(66, 459, 130, 25);
        jk.setFont(new Font("Inter", Font.BOLD, 18));
        this.add(jk);

        lk = new JRadioButton("Laki-laki");
        lk.setBounds(306, 459, 140, 30);
        lk.setBackground(Color.orange);
        lk.setFocusPainted(false);

        pr = new JRadioButton("Perempuan");
        pr.setBounds(450, 459, 140, 30);
        pr.setBackground(Color.orange);
        pr.setFocusPainted(false);

        group3 = new ButtonGroup();
        group3.add(lk);
        group3.add(pr);

        this.add(lk);
        this.add(pr);

        alamat = new JLabel();
        alamat.setText("Alamat");
        alamat.setBounds(66, 546, 70, 25);
        alamat.setFont(new Font("Inter", Font.BOLD, 18));
        this.add(alamat);

        textAlamat = new JTextArea();
        textAlamat.setBounds(306, 524, 410, 70);
        textAlamat.grabFocus();
        this.add(textAlamat);

        buttonSmpn = new JButton("Simpan");
        buttonSmpn.setBounds(306, 618, 115, 40);
        buttonSmpn.setBackground(Color.black);
        buttonSmpn.setForeground(Color.white);
        buttonSmpn.setFocusable(false);
        add(buttonSmpn);
        buttonSmpn.addActionListener(this);
        buttonSmpn.setActionCommand("Simpan");

        ButtonRst = new JButton("Reset");
        ButtonRst.setBounds(441, 618, 125, 40);
        ButtonRst.setBackground(Color.black);
        ButtonRst.setForeground(Color.white);
        ButtonRst.setFocusable(false);
        add(ButtonRst);
        ButtonRst.addActionListener(this);
        ButtonRst.setActionCommand("Reset");

        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String data = e.getActionCommand();
        switch (data) {
            case "Simpan":

                String name = textNama.getText();
                String work = "";
                if (pn.isSelected()) {
                    work = "Pegawai Negeri";
                } else if (ps.isSelected()) {
                    work = "Pegawai Swasta";
                } else if (tnp.isSelected()) {
                    work = "TNI / POLRI";
                } else if (pljr.isSelected()) {
                    work = "Pelajar";
                } else if (mhs.isSelected()) {
                    work = "Mahasiswa";
                } else if (lny.isSelected()) {
                    work = "Lainnya";
                }

                String lD = "";
                if (sd.isSelected()) {
                    lD = "SD";
                } else if (smp.isSelected()) {
                    lD = "SMP";
                } else if (sma.isSelected()) {
                    lD = "SMA";
                } else if (d1.isSelected()) {
                    lD = "D1";
                } else if (d2.isSelected()) {
                    lD = "D2";
                } else if (d3.isSelected()) {
                    lD = "D3";
                } else if (s1.isSelected()) {
                    lD = "S1";
                } else if (s2.isSelected()) {
                    lD = "S2";
                } else if (s3.isSelected()) {
                    lD = "S3";
                }

                String Gender = "";
                if (lk.isSelected()) {
                    Gender = "Laki-laki";
                } else if (pr.isSelected()) {
                    Gender = "Perempuan";
                }

                String address = alamat.getText();

                Connection con = DBconnect.getConnection();
                PreparedStatement ps;

                try {
                    ps = con.prepareStatement("INSERT INTO `tabel_data`(`nama`, `pekerjaan`, `pendidikan_terakhir`, `jenis kelamin`, `alamat`) VALUES (?,?,?,?,?)");

                    ps.setString(1, name);
                    ps.setString(2, work);
                    ps.setString(3, lD);
                    ps.setString(4, Gender);
                    ps.setString(5, address);

                    if (textNama.getText().isEmpty() || textAlamat.getText().isEmpty() || group.getSelection() == null || group2.getSelection() == null || group3.getSelection() == null) {
                        JOptionPane.showMessageDialog(null, "Isi Semua Data", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Data Tersimpan");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                break;
            case "Reset":
                if (e.getSource() == ButtonRst) {
                    textNama.setText("");
                    textAlamat.setText("");
                    if (e.getSource() == ButtonRst) {
                        group.clearSelection();
                    }
                    if (e.getSource() == ButtonRst) {
                        group2.clearSelection();
                    }
                    if (e.getSource() == ButtonRst) {
                        group3.clearSelection();
                    }

                }
                JOptionPane.showMessageDialog(null, "Data di Reset");
                break;
            default:
                System.err.println("Error");
        }

    }

}
