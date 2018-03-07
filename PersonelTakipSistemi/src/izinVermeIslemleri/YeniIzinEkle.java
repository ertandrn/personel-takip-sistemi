package izinVermeIslemleri;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import veritabani.VeritabaniBaglantisi;

public class YeniIzinEkle {
    
    private final String birim;
    private final String kayitNo;
    private final String sicilNo;
    private final String kalanIzinMiktari;
    private final String izinBasTarihi;
    private final String izinBtsTarihi;
    private final String izinTuru;
    private final String kullanilanIzinMik;
    
    PreparedStatement ps;
    
    public YeniIzinEkle (String birim, String kayitNo, String sicilNo, String kalanIzinMiktari, String izinBasTarihi, String izinBtsTarihi, String izinTuru, String kullanilanIzinMik)
    {
        
        this.birim = birim;
        this.kayitNo = kayitNo;
        this.sicilNo = sicilNo;
        this.kalanIzinMiktari = kalanIzinMiktari;
        this.izinBasTarihi = izinBasTarihi;
        this.izinBtsTarihi = izinBtsTarihi;
        this.izinTuru = izinTuru;
        this.kullanilanIzinMik = kullanilanIzinMik;
        
    }
    
    public boolean izinVer(YeniIzinEkle y) 
    {
        
        try 
        {
            VeritabaniBaglantisi vb = new VeritabaniBaglantisi();
            vb.baglan();
            
            String sql = "INSERT INTO izinler(birim, kayit_no, sicil_no, kalan_izin_mik," + " izin_bas_tarih, izin_bts_tarih, izin_turu, kullanilan_izin_mik) VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = vb.con.prepareStatement(sql);
            
            ps.setString(1, y.birim);
            ps.setString(2, y.kayitNo);
            ps.setString(3, y.sicilNo);
            ps.setString(4, y.kalanIzinMiktari);
            ps.setString(5, y.izinBasTarihi);
            ps.setString(6, y.izinBtsTarihi);
            ps.setString(7, y.izinTuru);
            ps.setString(8, y.kullanilanIzinMik);
            
            ps.execute();
            
            vb.con.close();
            
            return true;
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "İzin Ekleme Hatası!\n" + e);
            return false;
        }
    }
}
