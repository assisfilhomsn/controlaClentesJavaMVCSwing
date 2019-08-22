package br.com.br.mca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactoty {
    
    private static final String urlBase = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String usuario = "system";
    private static final String senha = "system";
    
    public static Connection getConexao(){
        Connection conexao = null;
        
        try {
            conexao = DriverManager.getConnection(urlBase, usuario, senha);
            
            /*if (conexao != null) 
                System.out.println("Conexão com o Banco de Dados realizado com sucesso");*/
            
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro na Conexão: " +e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
        }
        
        return conexao;
    }
    
    
    //public static void closeConection (Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
    public static void closeConection (Connection conn, PreparedStatement ps, ResultSet rs) throws StandardException {
        close(conn, ps, rs);
    }
    
    public static void closeConection (Connection conn, PreparedStatement ps) throws StandardException {
        close(conn, ps, null);
    }
    
    public static void closeConection (Connection conn) throws StandardException {
        close(conn, null, null);
    }
        
    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws StandardException {
        try {
            if(conn != null)
                conn.close();
            if(ps != null)
                ps.close();
            if(rs != null) 
                rs.close();
                
        } catch (Exception e) {
            throw new StandardException(e.getMessage());
        }
    }
}
