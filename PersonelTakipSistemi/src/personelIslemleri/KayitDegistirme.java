/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personelIslemleri;

import java.awt.HeadlessException;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import veritabani.VeritabaniBaglantisi;

public class KayitDegistirme extends javax.swing.JFrame {

    /**
     * Creates new form KayitDegistirme
     */
    public KayitDegistirme() {
        initComponents();
        tabloGuncelle();
    }
    
    VeritabaniBaglantisi vb = new VeritabaniBaglantisi();
    
    public Statement baglantiAc() throws SQLException {
        
        try {
            Class.forName(vb.DRIVER).newInstance();
            vb.con = DriverManager.getConnection(vb.URL + vb.DB_NAME, vb.ID, vb.PW);
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "HATA\n" + e);
        }
        return vb.con.createStatement();
    }
    
    public void baglantiKapat() throws SQLException {
        vb.con.close();
    }
    
    public void tabloGuncelle() {
        
        try {
            Statement s = baglantiAc();
            String sql = "SELECT * FROM kisi_bilgi;";
            ResultSet rs = s.executeQuery(sql);
            PersonelTabloModelim model = new  PersonelTabloModelim(rs);
            tablom.setModel(model);
            baglantiKapat();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HATA\n" + e);
        }
    }
    
    public void personelEkle() {
        
        try {
            PersonelEkle personel = new PersonelEkle(
                    adTf.getText(),
                    soyadTf.getText(),
                    tcNoTf.getText(),
                    sicilNoTf.getText(),
                    cinsiyetTf.getText(),
                    dogumTarihiTf.getText(),
                    sehirTf.getText()
            );
            
            boolean durum = personel.personelEkle(personel);
            tabloGuncelle();
            textFieldTEmizle();
            
            if(durum) {
                JOptionPane.showMessageDialog(null, "Personel Ekleme Başarıyla Tamamlandı.");
            } else
                JOptionPane.showMessageDialog(null, "Personel Eklenemedi!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Personel Ekleme Hatası!\n" + e);
        }
    }
    
    public void personelSil(String sicilNo) {
        
        try {
            
            Statement s = baglantiAc();
            String sql = "DELETE FROM kisi_bilgi WHERE sicil_no = " + sicilNo;
            s.executeUpdate(sql);
            baglantiKapat();
            
            tabloGuncelle();
            textFieldTEmizle();
            
            JOptionPane.showMessageDialog(null, "Personel Başarıyla Silindi.");
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Personel Silinemedi!\n" + e);
        }
        
    }
    
    public void personelGuncelle(String ad, String soyad, String tcNo, String sicilNo,
            String cinsiyet, String dogumTarihi, String sehir, String guncellenecekVeriId) {
        
        try {
            
            String sql = "UPDATE kisi_bilgi SET " + 
                    "ad = '" + ad + 
                    "', soyad='" + soyad +
                    "', tc_no=" + tcNo + 
                    ", sicil_no=" + sicilNo +
                    ", cinsiyet='" + cinsiyet +
                    "', sehir='" + sehir +
                    "' WHERE sicil_no=" + guncellenecekVeriId;
            
            Statement s = baglantiAc();
            s.executeUpdate(sql);
                    baglantiKapat();
                    tabloGuncelle();
                    textFieldTEmizle();
                    JOptionPane.showMessageDialog(null, "Personel Başarıyla Güncellendi...");
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Güncellenecek SicilNo bulunamadı!\n" + e);
        }
    }
    
    public void textFieldTEmizle() {
        adTf.setText("");
        soyadTf.setText("");
        tcNoTf.setText("");
        sicilNoTf.setText("");
        cinsiyetTf.setText("");
        dogumTarihiTf.setText("");
        sehirTf.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        adTf = new javax.swing.JTextField();
        soyadTf = new javax.swing.JTextField();
        tcNoTf = new javax.swing.JTextField();
        sicilNoTf = new javax.swing.JTextField();
        cinsiyetTf = new javax.swing.JTextField();
        dogumTarihiTf = new javax.swing.JTextField();
        sehirTf = new javax.swing.JTextField();
        guncelleBtn = new javax.swing.JButton();
        temizleBtn = new javax.swing.JButton();
        silBtn = new javax.swing.JButton();
        ekleBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cikisYapBtn = new javax.swing.JButton();
        geriDonBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablom = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personel Güncelleme Ekranı"));

        jLabel1.setText("Ad:");

        jLabel2.setText("Soyad:");

        jLabel3.setText("Tc No:");

        jLabel4.setText("Sicil No:");

        jLabel5.setText("Cinsiyet:");

        jLabel6.setText("Doğum Tarihi:");

        jLabel7.setText("Şehir:");

        guncelleBtn.setText("Güncelle");
        guncelleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleBtnActionPerformed(evt);
            }
        });

        temizleBtn.setText("Temizle");
        temizleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleBtnActionPerformed(evt);
            }
        });

        silBtn.setText("Sil");
        silBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silBtnActionPerformed(evt);
            }
        });

        ekleBtn.setText("Ekle");
        ekleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Güncellemek veya silmek istediğiniz personel tabloda tıklanmış olmalı");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adTf)
                            .addComponent(soyadTf)
                            .addComponent(tcNoTf)
                            .addComponent(sicilNoTf)
                            .addComponent(cinsiyetTf)
                            .addComponent(dogumTarihiTf)
                            .addComponent(sehirTf)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(guncelleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(silBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(temizleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(ekleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(adTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(soyadTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tcNoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sicilNoTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cinsiyetTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dogumTarihiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sehirTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guncelleBtn)
                    .addComponent(temizleBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(silBtn)
                    .addComponent(ekleBtn))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        cikisYapBtn.setText("Çıkış Yap");
        cikisYapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisYapBtnActionPerformed(evt);
            }
        });

        geriDonBtn.setText("Geri Dön");
        geriDonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriDonBtnActionPerformed(evt);
            }
        });

        tablom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablomMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(geriDonBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cikisYapBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cikisYapBtn)
                    .addComponent(geriDonBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cikisYapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisYapBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cikisYapBtnActionPerformed

    private void geriDonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriDonBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new PersonelIslemleriMenu().setVisible(true);
    }//GEN-LAST:event_geriDonBtnActionPerformed

    private void ekleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleBtnActionPerformed
        // TODO add your handling code here:
        personelEkle();
    }//GEN-LAST:event_ekleBtnActionPerformed

    private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed
        // TODO add your handling code here:
        personelSil(tablom.getValueAt(tablom.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_silBtnActionPerformed

    private void guncelleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleBtnActionPerformed
        // TODO add your handling code here:
        personelGuncelle(
                adTf.getText(),
                soyadTf.getText(),
                tcNoTf.getText(),
                sicilNoTf.getText(),
                cinsiyetTf.getText(),
                dogumTarihiTf.getText(),
                sehirTf.getText(),
                tablom.getValueAt(tablom.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_guncelleBtnActionPerformed

    private void temizleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleBtnActionPerformed
        // TODO add your handling code here:
        textFieldTEmizle();
    }//GEN-LAST:event_temizleBtnActionPerformed
    
    private void tablomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablomMousePressed
        // TODO add your handling code here:
        adTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 0).toString());
        soyadTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 1).toString());
        tcNoTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 2).toString());
        sicilNoTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 3).toString());
        cinsiyetTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 4).toString());
        dogumTarihiTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 5).toString());
        sehirTf.setText(tablom.getValueAt(tablom.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tablomMousePressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KayitDegistirme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayitDegistirme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayitDegistirme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayitDegistirme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayitDegistirme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adTf;
    private javax.swing.JButton cikisYapBtn;
    private javax.swing.JTextField cinsiyetTf;
    private javax.swing.JTextField dogumTarihiTf;
    private javax.swing.JButton ekleBtn;
    private javax.swing.JButton geriDonBtn;
    private javax.swing.JButton guncelleBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sehirTf;
    private javax.swing.JTextField sicilNoTf;
    private javax.swing.JButton silBtn;
    private javax.swing.JTextField soyadTf;
    private javax.swing.JTable tablom;
    private javax.swing.JTextField tcNoTf;
    private javax.swing.JButton temizleBtn;
    // End of variables declaration//GEN-END:variables
}
