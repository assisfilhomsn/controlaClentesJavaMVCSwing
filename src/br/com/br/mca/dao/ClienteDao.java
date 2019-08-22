package br.com.br.mca.dao;

import br.com.br.mca.model.Cliente;
import br.com.br.mca.util.ConnectionFactoty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDao extends Dao<Cliente>{
    
    

    @Override
    public boolean cadastrar(Cliente cliente) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        PreparedStatement ps = null;
        String sql = "Insert into system.cliente (CLI_COD, CLI_NOME, CLI_CPF, CLI_DT_NASC, CLI_SEXO, CLI_FONE, CLI_ENDERECO) values (cliente_seq.nextval,?,?,?,?,?,?)";
        
        try {
            Connection conn = this.obterConexao();
            try {
              ps = conn.prepareStatement(sql);
              ps.setString(1, cliente.getNome());
              ps.setString(2, cliente.getCpf());
              ps.setDate(3, cliente.getNascimento());
              ps.setString(4, cliente.getSexo());
              ps.setString(5, cliente.getFone());
              ps.setString(6,cliente.getEndereco());
              ps.executeUpdate();
              
            } finally {
                try {
                    ConnectionFactoty.closeConection(conn,ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean alterar(Cliente cliente) throws SQLException {
        PreparedStatement ps = null;
        String sql = " update cliente \n " +
                     " set CLI_NOME = ?, CLI_CPF = ?, CLI_DT_NASC = ?, CLI_SEXO = ?, CLI_FONE = ?, CLI_ENDERECO = ?\n " +
                     " where cli_cod = ? ";
        
        try {
            Connection conn = this.obterConexao();
            try {
              ps = conn.prepareStatement(sql);
              ps.setString(1, cliente.getNome());
              ps.setString(2, cliente.getCpf());
              ps.setDate(3, cliente.getNascimento());
              ps.setString(4, cliente.getSexo());
              ps.setString(5, cliente.getFone());
              ps.setString(6,cliente.getEndereco());
              ps.setInt(7,cliente.getCodigo());
              ps.executeUpdate();
              
            } finally {
                try {
                    ConnectionFactoty.closeConection(conn,ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public boolean excluir(Cliente cliente) throws SQLException {
        PreparedStatement ps = null;
        String sql = " delete cliente where cli_cod = ? ";
        
        try {
            Connection conn = this.obterConexao();
            try {
              ps = conn.prepareStatement(sql);
              ps.setInt(1,cliente.getCodigo());
              ps.executeUpdate();
              
            } finally {
                try {
                    ConnectionFactoty.closeConection(conn,ps);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    @Override
    public Integer getCodigo(Cliente cliente) throws SQLException {
        PreparedStatement ps = null;
        Integer codigo = null;
        String sql = "Select cli_cod from cliente where cli_cpf = ?";
        
        try {
            Connection conn = this.obterConexao();  // Conectamos a nossa base de Dados
            ps = conn.prepareStatement(sql); // Prepara o SQL
            ps.setString(1, cliente.getCpf()); // Aponta para o campo da informação do SQL e pode editar, deletar, etc. 
            ResultSet rs = ps.executeQuery(); // Executa o SQL
            
            // Se retorna uma linha
            if (rs.next()){
                cliente.setCodigo(rs.getInt("cli_cod")); // pega o valor do campo da Tabela
                codigo = cliente.getCodigo(); // Grava na Variavel de Objeto (Atributo)
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return codigo;
    }
    

    @Override
    public ArrayList<Cliente> TodosOsClientes() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("Select CLI_COD, CLI_NOME, CLI_CPF, CLI_SEXO, CLI_DT_NASC, CLI_FONE  from cliente order by CLI_COD desc ");

        Connection conexao = ConnectionFactoty.getConexao();
        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        //comando.setString(1, "%" + c.getDescricao() + "%" ); // Tratando o parametro usando as definições de like (%) do SQL ANSI
        ResultSet resultado = comando.executeQuery(); // Executa a Query e guarda o resultado do SQL na variavel "resultado" 

        ArrayList<Cliente> listaGrid = new ArrayList<>();
        while (resultado.next()) {
           Cliente cliente = new Cliente(); 
           cliente.setCodigo(resultado.getInt("CLI_COD"));
           cliente.setNome(resultado.getString("CLI_NOME"));
           cliente.setCpf(resultado.getString("CLI_CPF"));
           cliente.setSexo(resultado.getString("CLI_SEXO"));
           cliente.setNascimento(resultado.getDate("CLI_DT_NASC"));
           cliente.setFone(resultado.getString("CLI_FONE"));
           listaGrid.add(cliente);
           }

        return listaGrid; // Retorno do Tipo ArrayList de Fornecedores. (Aqui guarda todas as informações)  
    }
    
}
