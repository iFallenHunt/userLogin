package mapaprogii.core.entity.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoJDBC {

    private static final String url = "jdbc:mysql://localhost:3306/mapa";
    private static final String user = "root";
    private static final String password = "81768241";

    private static Connection conn;

    public static Connection getConexao() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com o banco", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
