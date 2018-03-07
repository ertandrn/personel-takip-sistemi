package veritabani;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GirisYap {
    
    public boolean girisYap(String alinanAd, String alinanSifre) 
                                                          throws SQLException {
        
        PreparedStatement ps;
        ResultSet rs;
        
        VeritabaniBaglantisi vb = new VeritabaniBaglantisi();
        try {
            vb.baglan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veritabanı Bağlantı Hatası!"
                    + e);
        }

        String sql = "SELECT sifre FROM admin WHERE kadi=?";
        ps = vb.con.prepareStatement(sql);
        ps.setString(1, alinanAd);
        rs = ps.executeQuery();
        
        while(rs.next()) {
            String gercekSifre = rs.getString("sifre");
            return gercekSifre.equals(alinanSifre);
        }

        throw new UnsupportedOperationException();
    }
}
