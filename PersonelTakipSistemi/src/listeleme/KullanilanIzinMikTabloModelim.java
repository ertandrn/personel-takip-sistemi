package listeleme;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class KullanilanIzinMikTabloModelim extends AbstractTableModel {

    private int satirSayisi;
    private int sutunSayisi;

    private ResultSet rs;
    
    private ArrayList veriler = new ArrayList();
    
    public KullanilanIzinMikTabloModelim(ResultSet rs) throws SQLException {
        
        this.rs = rs;
        
        ResultSetMetaData rsmd = rs.getMetaData();
        
        satirSayisi = 0;
        
        sutunSayisi = rsmd.getColumnCount();
        
        while(rs.next()) {
            
            Object[] satirBilgi = new Object[sutunSayisi];
            
            for(int i = 0; i < sutunSayisi; i++) {
                satirBilgi[i] = rs.getObject(i + 1);
            }
            
            veriler.add(satirBilgi);
            
            satirSayisi++;
        }
    }
    
    @Override
    public int getRowCount() {
        return satirSayisi;
    }

    @Override
    public int getColumnCount() {
        return sutunSayisi;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] satirBilgi = (Object[]) veriler.get(rowIndex);
        
        return satirBilgi[columnIndex];
    }
    
    public String[] sutunIsimleri = {"Ad", "Soyad", "Kullanılan İzin Toplamı"};
    @Override
    public String getColumnName(int sutunIndex) {
        
        return sutunIsimleri[sutunIndex];
    }
}