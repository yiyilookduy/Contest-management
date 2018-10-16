/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.daos;

import duypn.classes.AbstractDAO;
import duypn.conn.MyConnection;
import java.sql.ResultSet;

/**
 *
 * @author duypnse63523
 */
public class ProvinceDAO extends AbstractDAO {
    
    private static ProvinceDAO instance;
    public static ProvinceDAO Instance(){
        if(instance==null) instance = new ProvinceDAO();
        return instance;
    }
    
    public String GetProvinceName(int provinceId) throws Exception{
        String provinceName = null;
        try {
            String sql = "SELECT Name FROM dbo.Province WHERE ID = ?";
        conn = MyConnection.GetMyConnection();
        preStm = conn.prepareStatement(sql);
        preStm.setInt(1, provinceId);
        rs = preStm.executeQuery();
        if(rs.next())
            provinceName = rs.getString("Name");
        } finally {
            CloseConnection();
        }
        return provinceName;
    }
    
    public int getProvinceId(String provinceName) throws Exception {
        int provinceId = 0;
        try {
            String sql = "Select ID FROM dbo.Province WHERE Name = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, provinceName);
            rs = preStm.executeQuery();
            if(rs.next())
                provinceId = rs.getInt("ID");
        } finally{
            CloseConnection();
        }
        return provinceId;
    }
}
