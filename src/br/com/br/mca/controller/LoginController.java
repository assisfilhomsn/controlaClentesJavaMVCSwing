package br.com.br.mca.controller;

import br.com.br.mca.dao.LoginDao;
import br.com.br.mca.model.Login;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {
    
    public ArrayList<Login> buscarLoginSenha() throws SQLException, ClassNotFoundException{
        return LoginDao.buscarLogin();
    }
    
}
