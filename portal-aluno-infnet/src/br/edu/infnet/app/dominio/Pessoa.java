package br.edu.infnet.app.dominio;

import br.edu.infnet.app.auxiliar.Constante;
import br.edu.infnet.app.exceptions.NomeIncompletoException;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String ultimoNome;

    public Pessoa(){ 
        this.nome = Constante.NOME_PADRAO;
        this.sobrenome = Constante.SOBRENOME_PADRAO;
        this.ultimoNome = Constante.ULTIMO_NOME_PADRAO;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void imprimir() {
        System.out.printf(nome);
    }

    @Override
    public String toString() {
        return nome + " | " + sobrenome + " | " + ultimoNome;
    }

    public String getNome() throws NomeIncompletoException{

        if(nome == null || sobrenome == null || ultimoNome == null){
            throw new NomeIncompletoException(Constante.ERROR_NOME_INCOMPLETO);
        }

        // Luan E. Almeida
        StringBuilder sb = new StringBuilder();
        sb.append(nome.toUpperCase());
        sb.append(" ");
        sb.append(sobrenome.toUpperCase().charAt(0));
        sb.append(".");
        sb.append(" ");
        sb.append(ultimoNome.toUpperCase());
        sb.append(".");

        return sb.toString();
    }

    public void setNome(String nome) throws NomeIncompletoException{
        this.nome = nome;

        int posIn = nome.indexOf(" ");
        int posFinal = nome.lastIndexOf(" ");

        if(posIn < 0 || posFinal < 0) {
            throw new NomeIncompletoException(Constante.ERROR_NOME_INCOMPLETO);
        }

        this.nome = nome.substring(0, posIn);
        this.sobrenome = nome.substring(posIn, posFinal).trim();
        this.ultimoNome = nome.substring(posFinal).trim();
    }



}
