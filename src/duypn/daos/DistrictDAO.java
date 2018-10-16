/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.daos;

import duypn.classes.AbstractDAO;
import duypn.conn.MyConnection;

import java.io.Serializable;

/**
 *
 * @author duypnse63523
 */
public class DistrictDAO extends AbstractDAO implements Serializable {
    
    private static DistrictDAO instance;
    public static DistrictDAO Instance(){
        if(instance == null) instance = new DistrictDAO();
        return instance;
    }
    
    public String getDistrictName (int DistrictId) throws Exception{
        String DistrictName = null;
        try {
            String sql = "SELECT Name FROM dbo.District WHERE ID = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, DistrictId);
            rs = preStm.executeQuery();
            if(rs.next())
                DistrictName = rs.getString("Name");
        } finally{
            CloseConnection();
        }
        return DistrictName;
    }
    
    public int getDistrictId(String districtName) throws Exception {
        int districtId = 0;
        try {
            String sql = "Select ID FROM dbo.District WHERE Name = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, districtName);
            rs = preStm.executeQuery();
            if(rs.next())
                districtId = rs.getInt("ID");
        } finally{
            CloseConnection();
        }
        return districtId;
    }
}
