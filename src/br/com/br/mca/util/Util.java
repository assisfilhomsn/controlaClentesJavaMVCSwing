package br.com.br.mca.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Util {

    /*
    public static Date converterToDate(java.sql.Date rowData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    */
    
    // Recebe como parametro uma Data em formato String
public static Date converterToDate(String stringData) {
        DateFormat df; // Variavel que vai pegar o formato da Data
        Date data = new Date(); // Instancia uma Data
        
        try {
            df = new SimpleDateFormat("dd/MM/yyyy"); // Apresenta a formatação na Variavel
            data = df.parse(stringData); // Converte a String formatada para Data no Tipo Data (Entrando como parametro String)
            
        } catch (ParseException ex) {
            JOptionPane.showInputDialog(null,"Ocorreu um erro converteParaData: "+ex);
        }
        
        return data;
        
    }

    public static Object converterToString(Date data) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DateFormat df;
        String dataString = null;
        
        df = new SimpleDateFormat("dd/MM/yyyy");
        dataString = df.format(data);
        
        return dataString;
    }
        
}
