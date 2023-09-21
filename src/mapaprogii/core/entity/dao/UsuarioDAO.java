package mapaprogii.core.entity.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mapaprogii.core.entity.dao.conexao.ConexaoJDBC;
import mapaprogii.core.entity.Usuario;

public class UsuarioDAO {

    public void inserir(Usuario usuario) {
        
        String sql = "INSERT INTO USUARIO (nome, login, senha, email) VALUES (?,?,?,?)";
        
        PreparedStatement ps;
        
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setInt(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            
            
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public Usuario buscaPorLogin(String login, Integer senha){
        String sql = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        
        PreparedStatement ps = null;
        Usuario usuario = null;
        
        try {
        ps = ConexaoJDBC.getConexao().prepareStatement(sql);
        ps.setString(1, login);
        ps.setInt(2, senha);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getInt("senha"));
            usuario.setEmail(rs.getString("email"));
            return usuario;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return usuario;
}
    
}