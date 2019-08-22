
package br.com.br.mca.dao;

import br.com.br.mca.model.Cliente;
import br.com.br.mca.util.ConnectionFactoty;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<Entity> {
    
    protected Connection obterConexao() throws SQLException{
        return ConnectionFactoty.getConexao(); 
    };
    
    public abstract boolean cadastrar(Entity pojo) throws SQLException;
    public abstract boolean alterar(Entity pojo) throws SQLException;
    public abstract boolean excluir(Entity pojo) throws SQLException;
    public abstract Integer getCodigo(Entity pojo) throws SQLException;
    public abstract ArrayList<Cliente> TodosOsClientes() throws SQLException;

}
