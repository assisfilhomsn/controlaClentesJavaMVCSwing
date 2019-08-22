package br.com.br.mca.controller;

import br.com.br.mca.dao.ClienteDao;
import br.com.br.mca.dao.Dao;
import br.com.br.mca.model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteController extends Dao<Cliente>{

    @Override
    public boolean cadastrar(Cliente cliente) throws SQLException {
        boolean resultado = false;
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.cadastrar(cliente)){
            resultado = true;
        }
        return resultado;
    }

    @Override
    public boolean alterar(Cliente cliente) throws SQLException {
        boolean resultado = false;
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.alterar(cliente)){
            resultado = true;
        }
        return resultado;
    }

    @Override
    public boolean excluir(Cliente cliente) throws SQLException {
        boolean resultado = false;
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.excluir(cliente)){
            resultado = true;
        }
        return resultado;
    }

    @Override
    public Integer getCodigo(Cliente cliente) throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.getCodigo(cliente);
    }

    @Override
    public ArrayList<Cliente> TodosOsClientes() throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.TodosOsClientes();
    }
    
    
}
