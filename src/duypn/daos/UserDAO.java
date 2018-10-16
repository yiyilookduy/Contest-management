/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.daos;

import duypn.classes.AbstractDAO;
import duypn.conn.MyConnection;
import duypn.dtos.UserDTO;

/**
 *
 * @author duypnse63523
 */
public class UserDAO extends AbstractDAO {
    
    private static UserDAO instance;
    public static UserDAO Instance(){
        if(instance == null) instance = new UserDAO();
        return instance;
    }
    
    public UserDTO getUserInfo(String username) throws Exception{
       UserDTO user = null;
        try {
            String sql = "SELECT * FROM dbo.Users Where Username = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if(rs.next()){
                user = new UserDTO();
                user.setAddress(rs.getString("Address"));
                user.setDistrictId(rs.getInt("DistrictId"));
                user.setFirstname(rs.getString("FirstName"));
                user.setLastname(rs.getString("LastName"));
                user.setPhone(rs.getString("Phone"));
                user.setProvinceId(rs.getInt("ProvinceId"));
                user.setTotalEvent(rs.getInt("TotalEvent"));
                user.setType(rs.getString("Type"));
                user.setUsername(rs.getString("Username"));
                user.setWardId(rs.getInt("WardId"));
            }
        } finally{
            CloseConnection();
        }
       return user;
    }
    
    public boolean updateUserInfo(UserDTO user) throws Exception {
        boolean result = false;
        try {
            String sql = "UPDATE Users SET FirstName= ? , LastName= ?, ProvinceId= ?, DistrictId = ?, WardId = ?, Phone = ?, Address = ?, TotalEvent = ?, Type = ? "
                    + "Where Username = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user.getFirstname());
            preStm.setString(2, user.getLastname());
            preStm.setInt(3, user.getProvinceId());
            preStm.setInt(4, user.getDistrictId());
            preStm.setInt(5, user.getWardId());
            preStm.setString(6, user.getPhone());
            preStm.setString(7, user.getAddress());
            preStm.setInt(8, user.getTotalEvent());
            preStm.setString(9, user.getType());
            preStm.setString(10, user.getUsername());
            
            result = preStm.executeUpdate()> 0;
        } finally{
            CloseConnection();
        }
        return result;
    }
}
