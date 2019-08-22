package br.com.br.mca.util;

public enum OperacoesCrud {
    
    NOVO(1), EDITAR(2), EXCLUIR(3); // Constantes (Enum)
    
    private final Integer operacao; // variavel que vai atribuir o valor da constante
    
    // Método Construtor que vai atribuir valor a variavel relacionado a constante Enum
    private OperacoesCrud(Integer operacao){
        this.operacao = operacao;
    }
    
    // Só necewssário o Getter (Atribuido pelo Construtor)
    public Integer getOperacao(){
        return operacao;
    }
    
}
