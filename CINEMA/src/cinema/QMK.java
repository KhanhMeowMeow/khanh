/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import DAO.NhanVienDAO;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utils.XEmail;

/**
 *
 * @author ngoth
 */
public class QMK {
    
    int h = 400, w = 600;
    // ch: component high
    int ch = h / 10;
    int cw = w / 4;
    int x = 10, y = 10;
    
    JFrame mainFrame;
    JLabel lblTitle,lblTitle1, lblClose, lblEmail, lblOTP,lblmain, lblbutton,lblmk,lblmk1;
    JTextField txtEmail, txtOTP,txtmk,txtmk1;
    JPanel fiPanel, sePanel;
    JButton btnGui,btnXacNhan,btnXacnhan1;

    public QMK() {
        myGUI();
    }
    
    private void myGUI(){
        mainFrame = new JFrame();
        mainFrame.setSize(w, h);
        mainFrame.setLayout(null);
        //mainFrame.getContentPane().setBackground(new Color(255,240,235));
       // mainFrame.setUndecorated(true);
        mainFrame.setLocationRelativeTo(null);
        
        
        fiPanel = new JPanel();
        fiPanel.setBounds(10, 0, w, h);
        fiPanel.setLayout(null);
        fiPanel.setOpaque(true);
       // fiPanel.setBackground(new Color(255,240,235));
        mainFrame.add(fiPanel); 
        
        lblTitle = new JLabel("QUÊN MẬT KHẨU",JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", 1, 35));
        lblTitle.setBounds(20, y, w-100, ch);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(255,240,235));
        fiPanel.add(lblTitle);
        
        lblmain = new JLabel("Email");
        lblmain.setBounds(30, 80, cw/3, ch);
        lblmain.setOpaque(true);
        lblmain.setBackground(Color.yellow);
        fiPanel.add(lblmain);
        
        txtEmail = new JTextField();
        txtEmail.setBorder(new LineBorder(Color.black, 1, true));
        txtEmail.setBounds(110, 80, cw*2+20, ch);
        fiPanel.add(txtEmail);
        
        btnGui = new JButton("GUI");
        btnGui.setBounds(cw*3-10, 80, 100, ch);
        btnGui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xacNhanNV();
            }
        });
        fiPanel.add(btnGui);
        
        lblOTP = new JLabel("OTP");
        //lblOTP.setFont(new Font("Arial", 1, 35));
        lblOTP.setBounds(30, 150, cw/3, ch);
        lblOTP.setOpaque(true);
        lblOTP.setBackground(new Color(255,240,235));
        fiPanel.add(lblOTP);
        
        txtOTP = new JTextField();
        txtOTP.setBorder(new LineBorder(Color.black, 1, true));
        txtOTP.setBounds(110, 150, cw*2+20, ch);
        fiPanel.add(txtOTP);
        
        btnXacNhan = new JButton("XÁC NHẬN");
        btnXacNhan.setBounds(160, 220, cw, ch);
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xacNhan();
            }
        });
        fiPanel.add(btnXacNhan);
        
        sePanel = new JPanel();
        sePanel.setBounds(10, 0, w, h);
        sePanel.setLayout(null);
                
        lblTitle1 = new JLabel("QUÊN MẬT KHẨU",JLabel.CENTER);
        lblTitle1.setFont(new Font("Arial", 1, 35));
        lblTitle1.setBounds(20, y, w-100, ch);
        lblTitle1.setOpaque(true);
        lblTitle1.setBackground(new Color(235,245,235));
        sePanel.add(lblTitle1);
        
        lblmk = new JLabel("MK");
        lblmk.setBounds(30, 80, cw/3, ch);
        lblmk.setOpaque(true);
        lblmk.setBackground(Color.yellow);
        sePanel.add(lblmk);
        
        txtmk = new JTextField();
        txtmk.setBorder(new LineBorder(Color.black, 1, true));
        txtmk.setBounds(110, 80, cw*2+20, ch);
        sePanel.add(txtmk);
        
        lblmk1 = new JLabel("Xac nhan");
        //lblOTP.setFont(new Font("Arial", 1, 35));
        lblmk1.setBounds(30, 150, cw/3+20, ch);
        lblmk1.setOpaque(true);
        lblmk1.setBackground(new Color(255,240,235));
        sePanel.add(lblmk1);
        
        txtmk1 = new JTextField();
        txtmk1.setBorder(new LineBorder(Color.black, 1, true));
        txtmk1.setBounds(110, 150, cw*2+20, ch);
        sePanel.add(txtmk1);
        
        btnXacnhan1 = new JButton("XÁC NHẬN");
        btnXacnhan1.setBounds(160, 220, cw, ch);
        btnXacnhan1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doiMK();
            }
        });
        sePanel.add(btnXacnhan1);
        
        mainFrame.add(sePanel);        
        mainFrame.setVisible(true);
    }
    
    
    //////////////////////////////////
    Thread t;
    String maXacThuc = "";
        
        private void guiMa(NhanVien nv) {
        if (nv != null) {
            for (int i = 0; i < 6; i++) {
                int ran = (int) (65 + Math.random() * 25);
                maXacThuc += String.valueOf((char) ran);
            }
            String[] thongTin = {nv.getEmailNV(), maXacThuc};
            XEmail mail = new XEmail(thongTin, 1);
            mail.guiEmail();
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 59; i >= 0; i--) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {}
                        String text = "Bạn còn " + String.valueOf(i) + " giây!!";
                       // lblThongBao.setText(text);
                        if (i == 0) {
                            ;
                            break;
                        }
                    }
                }
            });
            t.start();
        }
       }
        NhanVienDAO dao = new NhanVienDAO();
        private NhanVien xacNhanNV() {
        String email = txtEmail.getText();
        NhanVien nv = dao.SelectById(email);
        if (nv == null) {
            JOptionPane.showMessageDialog(null,"Mã nhân viên không đúng");           
        }
        ///111
            guiMa(nv);
        return nv;
    }

    private void xacNhan() {
        String maXacNhan = txtOTP.getText();
        if (maXacNhan.equals("")) {
            JOptionPane.showMessageDialog(null,"Mã xác thực không đúng");
        } else {
            if (maXacNhan.equals(maXacThuc)) {
                fiPanel.setVisible(false);
                sePanel.setVisible(true);
                t.stop();
                JOptionPane.showMessageDialog(null,"Mời bạn đổi mật khẩu");
            } else {
                JOptionPane.showMessageDialog(null,"Mã xác nhận không đúng");
            }
        }
    }
    
    private void doiMK() {
        String mk1 = txtmk.getText();
        String mk2 = txtmk1.getText();

        if (mk1.equals("") || mk2.equals("")) {
            JOptionPane.showMessageDialog(null,"Xin điền đầy đủ mật khẩu!!");
        } else {
            if (!mk1.equals(mk2)) {
                JOptionPane.showMessageDialog(null,"Mật khẩu và mật khẩu xác thực không đúng!!");
            } else {
                NhanVien nv = dao.SelectById(txtEmail.getText());
                nv.setMatKhau(mk1);
                dao.Update(nv);
                JOptionPane.showMessageDialog(null, "Đã đổi mật khẩu thành công!!");
                mainFrame.dispose();
            }
        }
    }
    
    public static void main(String[] args) {
        new QMK();
    }
}
