/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duypn.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author duypnse63523
 */
public abstract class AbstractDAO {
    
    protected Connection conn;
    protected PreparedStatement preStm;
    protected ResultSet rs;
    
    protected void CloseConnection() throws Exception {
        if(rs!= null ) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
}
