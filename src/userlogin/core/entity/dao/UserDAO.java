package userlogin.core.entity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import userlogin.core.entity.dao.connection.ConnectionJDBC;
import userlogin.core.entity.User;

public class UserDAO {

    public void inserir(User user) {
        
        String sql = "INSERT INTO USUARIO (name, login, password, email) VALUES (?,?,?,?)";
        
        PreparedStatement ps;
        
        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setInt(3, user.getPassword());
            ps.setString(4, user.getEmail());
            
            
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public User searchByLogin(String login, Integer password){
        String sql = "SELECT id, name, login, password , email from user where login = ? and password = ?";
        
        PreparedStatement ps = null;
        User user = null;
        
        try {
        ps = ConnectionJDBC.getConnection().prepareStatement(sql);
        ps.setString(1, login);
        ps.setInt(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getInt("password"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return user;
}
    
}