/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.daos;

import duypn.classes.AbstractDAO;
import duypn.conn.MyConnection;

/**
 *
 * @author duypnse63523
 */
public class WardDAO extends AbstractDAO {
    
    private static WardDAO instance;
    public static WardDAO Instance(){
        if(instance == null) instance = new WardDAO();
        return instance;
    }
    
    public String getWardName(int WardId) throws Exception {
        String wardName = null;
        try {
            String sql = "SELECT Name FROM dbo.Ward WHERE ID = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, WardId);
            rs = preStm.executeQuery();
            if(rs.next()) wardName = rs.getString("Name");
        } finally{
            CloseConnection();
        }
        return wardName;
    }
    
    public int getWardId(String wardName) throws Exception {
        int wardId = 0;
        try {
            String sql = "Select ID FROM dbo.Ward WHERE Name = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, wardName);
            rs = preStm.executeQuery();
            if(rs.next())
                wardId = rs.getInt("ID");
        } finally{
            CloseConnection();
        }
        return wardId;
    }
}
