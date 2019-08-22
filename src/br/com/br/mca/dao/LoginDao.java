
package br.com.br.mca.dao;

import br.com.br.mca.model.Login;
import br.com.br.mca.util.ConnectionFactoty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginDao {
         
    public static ArrayList<Login> buscarLogin() throws SQLException{
        ArrayList<Login> loginAux = new ArrayList<>(); // Todos as linhas da tabela Login fica nessa variavel
        String sql = "Select log_nome, log_senha from login"; // Consultando a Tabela de Login
        
        Connection conn = ConnectionFactoty.getConexao(); // Conectando ao Banco Oracle
        PreparedStatement ps = conn.prepareStatement(sql); // Preparando o SQL para execução
        
        ResultSet rs = ps.executeQuery(); // Executa o SQL
        
        // Varrendo o resutado da Quary (Inicio)
        while (rs.next()) {            
            Login login = new Login(); // Instancia da Classe entidade Login
            login.setLogin(rs.getString("log_nome")); // Atribuindo valor encontrado 
            login.setSenha(rs.getString("log_senha"));
            
            loginAux.add(login); // Adicionando a linha da tabela ao ArrayList
        }
        // Varrendo o resutado da Quary (Fim)
        return loginAux; // Retorno os valores adicionados no ArrayList
        
        
        
        //return loginAux; // Retorno os valores adicionados no ArrayList
        
    }
    
}
