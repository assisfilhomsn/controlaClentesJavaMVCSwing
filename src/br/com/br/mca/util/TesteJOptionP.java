package br.com.br.mca.util;

import javax.swing.JOptionPane;

public class TesteJOptionP {
    public static void main(String[] args){
        /*
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        String sobreNome = JOptionPane.showInputDialog("Digite o Sober Nome:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua Idade: "));
                
        String nomeCompleto = nome + " " + sobreNome;
        
        JOptionPane.showMessageDialog(null, "Nome Completo" + nomeCompleto + " " + idade, 
                "Informação", JOptionPane.INFORMATION_MESSAGE);
        */
        
        ConnectionFactoty.getConexao();
    }
      
}
