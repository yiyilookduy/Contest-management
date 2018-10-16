/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.daos;

import duypn.classes.AbstractDAO;
import duypn.conn.MyConnection;
import duypn.dtos.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author duypnse63523
 */
public class AccountDAO extends AbstractDAO{
    
    private static AccountDAO instance;
    public static AccountDAO Instance(){
        if(instance == null) instance = new AccountDAO();
        return instance;
    }
    
    public String CheckLogin(String username, String password) throws ClassNotFoundException, SQLException, Exception{
        String role = "failed";
        try {
            String sql = "Select Role FROM dbo.Account WHERE Username = ? AND Password = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                role = rs.getString("Role");
            }
            return role;
        } finally{
            CloseConnection();
        }
    }
    
    public AccountDTO Login(String username, String password) throws Exception{
        AccountDTO account = null;
        try {
            String sql = "Select Username, Role, Email FROM dbo.Account WHERE Username = ? AND Password = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                account = getAccountFromResultSet(rs);
            }
            return account;
        } finally {
            CloseConnection();
        }
    }
    
    public AccountDTO getAccount(String username) throws Exception{
        AccountDTO account = null;
        try {
            String sql = "Select Username, Role, Email FROM dbo.Account WHERE Username = ?";
            conn = MyConnection.GetMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if(rs.next()){
                account = getAccountFromResultSet(rs);
            }
            return account;
        } finally {
             CloseConnection();
        }
    }

    private AccountDTO getAccountFromResultSet(ResultSet rs) throws Exception {
        String Role = rs.getString("Role");
        String Email = rs.getString("Email");
        String Username = rs.getString("Username");
        AccountDTO account = new AccountDTO();
        account.setEmail(Email);
        account.setRole(Role);
        account.setUsername(Username);
        return account;
    }
    
}
