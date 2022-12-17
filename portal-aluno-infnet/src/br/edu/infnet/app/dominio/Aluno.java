package br.edu.infnet.app.dominio;

import br.edu.infnet.app.auxiliar.Constante;

public class Aluno extends Pessoa{
    private float notaAV1;
    private float notaAV2;

    public Aluno(){   
    }

    public Aluno(String nome) {
        super(nome);
    }

    public Aluno(String nome, float notaAV1, float notaAV2) {
        this(nome);
        this.notaAV1 = notaAV1;
        this.notaAV2 = notaAV2;
    }

    public float calcularMedia(){
        return (this.notaAV1 + this.notaAV2) / 2;
    }
    
    public String obterSituacao(float media){
        if (media < 4) {
            return Constante.REPROVADO;
        } else if (media >= 4 && media < 7) {
            return Constante.PENDENTE;
        } else {
            return Constante.APROVADO;
        }
    }

    @Override
    public void imprimir(){
        float media = calcularMedia();

        try {
            System.out.printf("Nome: %s | AV1: %.1f | Av2: %.1f | Média: %.1f | Situação: %s \n",
                         super.getNome(), notaAV1, notaAV2, media, obterSituacao(media));
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString() +  " | " + notaAV1 + " | " + notaAV2;
    }

    public float getNotaAV1(){
        return notaAV1;
    }
    public void setNotaAV1(float notaAV1){
        this.notaAV1 = notaAV1;
    }

    public float getNotaAV2(){
        return notaAV2;
    }
    public void setNotaAV2(float notaAV2){
        this.notaAV2 = notaAV2;
    }
}
