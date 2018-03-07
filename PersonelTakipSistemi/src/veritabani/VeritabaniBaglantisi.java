package veritabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class VeritabaniBaglantisi {
    
    public final String URL = "jdbc:mysql://localhost:3306/";
    public final String DB_NAME = "personel_takip_sistemi";
    public final String ID = "root";
    public final String PW = "";
    public final String DRIVER = "com.mysql.jdbc.Driver";
    
    public Connection con;
    
    public Statement baglan() {
        
        try {
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL + DB_NAME, ID, PW);

        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Veritabanına bağlantı başarısız oldu!    " + e);
        }
        
        return null;
    }

}
